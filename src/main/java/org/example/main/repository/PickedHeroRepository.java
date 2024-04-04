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
