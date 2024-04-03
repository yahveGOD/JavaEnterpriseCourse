package org.example.main.repository;


import lombok.Getter;
import org.example.main.entity.Ability;
import org.example.main.entity.Hero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AbilityRepository {
    private HeroRepository hr = new HeroRepository();
    @Getter
    private List<Ability> abilities;

    public AbilityRepository() {
        abilities = new ArrayList<>();
        Ability ability1 = new Ability(0,hr.getHeroes().get(0),"123","098","kel",1234,true);
        Ability ability2 = new Ability(1,hr.getHeroes().get(1),"12341213","8998","Kel'Thuzad",122,true);
        abilities.add(ability1);
        abilities.add(ability2);
    }


}

