package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.Hero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HeroRepository {
    @Getter
    private List<Hero> heroes;

    public HeroRepository() {
        heroes = new ArrayList<>();
        Hero hero1 = new Hero(0,"op",0.4F,0.6F,1400,20,20,20);
        Hero hero2 = new Hero(1,"ozxc",0.4F,0.6F,1500,26,27,29);
        heroes.add(hero1);
        heroes.add(hero2);
    }
}
