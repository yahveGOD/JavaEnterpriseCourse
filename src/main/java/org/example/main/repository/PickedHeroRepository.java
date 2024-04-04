package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.*;
import org.example.main.exception.IdNotFoundException;
import org.example.main.exception.PickedHeroNotFoundException;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PickedHeroRepository {

    private static List<PickedHero> pickedHeroList;
    public PickedHeroRepository()
    {
        save(PickedHero.builder()
                .hero(new Hero("123",0.5f,0.4f,1,1,1,1))
                .inventory(new Inventory(0.5f))
                .match(new Match(Duration.ofHours(0).plusMinutes(30).plusSeconds(45),"zxc",new GameMode("zxc","cc",true,11),10,10))
                .statistics(new Statistics(1,1,1,1))
                .user(new User("1","2","3","4",1341))
                .build());
        save(PickedHero.builder()
                .hero(new Hero("zxc",0.1f,0.1f,111,111,111,221))
                .inventory(new Inventory(0.1f))
                .match(new Match(Duration.ofHours(0).plusMinutes(30).plusSeconds(45),"Team",new GameMode("alter","qwerty",true,11),13,12))
                .statistics(new Statistics(3,1,5,7))
                .user(new User("11","12","33","44",1341))
                .build());
    }
    public PickedHero findByMatchAndHero(Match match, Hero hero)
    {

        return pickedHeroList.stream()
                .filter(x -> x.getHero() == hero)
                .filter(x -> x.getMatch() == match)
                .findFirst()
                .orElseThrow(PickedHeroNotFoundException::new);
    }

    public List<PickedHero> findAll()
    {
        return pickedHeroList;
    }

    public void save(PickedHero object){
        if(findObjectIndex(object)!= -1 && !pickedHeroList.isEmpty())
        {
            pickedHeroList.set(findObjectIndex(object),object);
        }
        pickedHeroList.add(object);

    }

    private int findObjectIndex(PickedHero object)
    {
        for(int i = 0;i < pickedHeroList.size();i++)
        {
            if(object.getHero() == pickedHeroList.get(i).getHero() && object.getMatch() == pickedHeroList.get(i).getMatch()){
                return i;
            }

        }
        return -1;
    }
    public void deleteById(Match match,Hero hero)
    {
        pickedHeroList.remove(findByMatchAndHero(match,hero));
    }
}
