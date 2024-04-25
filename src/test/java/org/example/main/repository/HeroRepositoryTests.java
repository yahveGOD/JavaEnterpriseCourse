package org.example.main.repository;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.entity.GameMode;
import org.example.main.entity.Hero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConfig.class, LiquibaseConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class HeroRepositoryTests {

    @Autowired
    private HeroRepository heroRepository;

    @Test
    public void givenHero_whenFindByName_thenOk() {
        Hero hero = Hero.builder()
                .winRate(0.5f)
                .pickRate(0.4f)
                .pickedTimes(1000)
                .strength(11)
                .agility(11)
                .intelligence(11)
                .name("zxqq")
                .build();
        Hero hero1 = Hero.builder()
                .winRate(0.5f)
                .pickRate(0.4f)
                .pickedTimes(1000)
                .strength(11)
                .agility(11)
                .intelligence(11)
                .name("zxqqqwqwe")
                .build();

        heroRepository.create(hero);
        heroRepository.create(hero1);
        List<Hero> testHero = heroRepository.findHeroesByName(hero1.getName());

        assertEquals(1, testHero.size());
        assertEquals(testHero.stream().allMatch(t -> t.getName().equals(hero1.getName())), hero1.getName() == hero1.getName());
    }

    @Test
    public void givenHero_whenFindByWinRate_thenOk() {
        Hero hero = Hero.builder()
                .winRate(0.5f)
                .pickRate(0.4f)
                .pickedTimes(1000)
                .strength(11)
                .agility(11)
                .intelligence(11)
                .name("zxqq")
                .build();
        Hero hero1 = Hero.builder()
                .winRate(0.5f)
                .pickRate(0.4f)
                .pickedTimes(1000)
                .strength(11)
                .agility(11)
                .intelligence(11)
                .name("zxqqqwqwe")
                .build();

        heroRepository.create(hero);
        heroRepository.create(hero1);

        List<Hero> testHero = heroRepository.findHeroesByWinRate(hero1.getWinRate());

        assertEquals(2, testHero.size());
        assertEquals(testHero.stream().allMatch(t -> t.getWinRate().equals(hero1.getWinRate())), true);
    }
}
