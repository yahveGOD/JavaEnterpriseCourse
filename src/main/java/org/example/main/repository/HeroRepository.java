package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.Hero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HeroRepository extends AbstractRepository<Hero> {

    public HeroRepository() {
        save(Hero.builder()
                .winRate(0.35f)
                .strength(24)
                .pickRate(0.5f)
                .pickedTimes(15000)
                .name("pudge")
                .intelligence(5)
                .agility(15)
                .build());
        save(Hero.builder()
                .winRate(0.77f)
                .strength(55)
                .pickRate(0.11f)
                .pickedTimes(55555)
                .name("wr")
                .intelligence(5)
                .agility(15)
                .build());
    }
}
