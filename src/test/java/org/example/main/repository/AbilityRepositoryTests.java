package org.example.main.repository;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.entity.Ability;
import org.example.main.entity.Hero;
import org.junit.Assert;
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
public class AbilityRepositoryTests {
    @Autowired
    private AbilityRepository abilityRepository;

    @Test
    public void givenAbility_whenFindByName_thenOk(){
        Ability ability = Ability.builder()
                .hero(Hero.builder()
                        .id(1L)
                        .build())
                .isPassive(false)
                .name("zxc")
                .fixedDamage(123)
                .description("111")
                .damageType("123")
                .build();
        Ability ability1 = Ability.builder()
                .hero(Hero.builder()
                        .id(1L)
                        .build())
                .isPassive(false)
                .name("zxc")
                .fixedDamage(123)
                .description("111")
                .damageType("123")
                .build();

        abilityRepository.create(ability);
        abilityRepository.create(ability1);

        List<Ability> testAbility = abilityRepository.findAbilitiesByName(ability.getName());

        Assert.assertNotNull(testAbility);
        assertEquals(testAbility.stream().allMatch(t -> t.getName().equals(ability.getName())),true);
    }

    @Test
    public void givenAbility_whenFindByDamageType_thenOk(){
        Ability ability = Ability.builder()
                .hero(Hero.builder()
                        .id(1L)
                        .build())
                .isPassive(false)
                .name("zxc")
                .fixedDamage(123)
                .description("111")
                .damageType("123")
                .build();
        Ability ability1 = Ability.builder()
                .hero(Hero.builder()
                        .id(1L)
                        .build())
                .isPassive(false)
                .name("qwe")
                .fixedDamage(123)
                .description("111")
                .damageType("123")
                .build();

        abilityRepository.create(ability);
        abilityRepository.create(ability1);

        List<Ability> testAbility = abilityRepository.findAbilitiesByName(ability.getDamageType());

        Assert.assertNotNull(testAbility);
        assertEquals(testAbility.stream().allMatch(t -> t.getDamageType().equals(ability.getDamageType())),true);
    }

    @Test
    public void givenAbility_whenFetchAbilitiesWithLazyAssociationsJPQL_thenOk(){

        Hero hero = Hero.builder()
                .name("ZZZ")
                .id(1L)
                .agility(10)
                .strength(11)
                .intelligence(12)
                .pickedTimes(1000)
                .pickRate(0.4f)
                .winRate(0.3f)
                .build();

        Ability ability = Ability.builder()
                .hero(hero)
                .isPassive(false)
                .name("zxc")
                .fixedDamage(123)
                .description("111")
                .damageType("123")
                .build();
        Ability ability1 = Ability.builder()
                .hero(hero)
                .isPassive(false)
                .name("qwe")
                .fixedDamage(123)
                .description("111")
                .damageType("123")
                .build();

        abilityRepository.create(ability);
        abilityRepository.create(ability1);

        List<Ability> testAbility = abilityRepository.fetchAbilitiesWithLazyAssociationsJPQL();

        Assert.assertNotNull(testAbility);
        assertEquals(11,testAbility.size());
        assertEquals(hero.getName(),testAbility.get(9).getHero().getName());
        assertEquals(hero.getName(),testAbility.get(10).getHero().getName());
    }

    @Test
    public void givenAbility_whenFetchAbilitiesWithLazyAssociationsCriteriaApi_thenOk(){

        Hero hero = Hero.builder()
                .name("ZZZ")
                .id(1L)
                .agility(10)
                .strength(11)
                .intelligence(12)
                .pickedTimes(1000)
                .pickRate(0.4f)
                .winRate(0.3f)
                .build();

        Ability ability = Ability.builder()
                .hero(hero)
                .isPassive(false)
                .name("zxc")
                .fixedDamage(123)
                .description("111")
                .damageType("123")
                .build();
        Ability ability1 = Ability.builder()
                .hero(hero)
                .isPassive(false)
                .name("qwe")
                .fixedDamage(123)
                .description("111")
                .damageType("123")
                .build();

        abilityRepository.create(ability);
        abilityRepository.create(ability1);

        List<Ability> testAbility = abilityRepository.fetchAbilitiesWithLazyAssociationsCriteriaApi();

        Assert.assertNotNull(testAbility);
        assertEquals(11,testAbility.size());
        assertEquals(hero.getName(),testAbility.get(9).getHero().getName());
        assertEquals(hero.getName(),testAbility.get(10).getHero().getName());
    }

    @Test
    public void givenAbility_whenFetchAbilitiesWithLazyAssociationsEntityGraph_thenOk(){

        Hero hero = Hero.builder()
                .name("ZZZ")
                .id(1L)
                .agility(10)
                .strength(11)
                .intelligence(12)
                .pickedTimes(1000)
                .pickRate(0.4f)
                .winRate(0.3f)
                .build();

        Ability ability = Ability.builder()
                .hero(hero)
                .isPassive(false)
                .name("zxc")
                .fixedDamage(123)
                .description("111")
                .damageType("123")
                .build();
        Ability ability1 = Ability.builder()
                .hero(hero)
                .isPassive(false)
                .name("qwe")
                .fixedDamage(123)
                .description("111")
                .damageType("123")
                .build();

        abilityRepository.create(ability);
        abilityRepository.create(ability1);

        List<Ability> testAbility = abilityRepository.fetchAbilitiesWithLazyAssociationsEntityGraph();

        Assert.assertNotNull(testAbility);
        assertEquals(11,testAbility.size());
        assertEquals(hero.getName(),testAbility.get(9).getHero().getName());
        assertEquals(hero.getName(),testAbility.get(10).getHero().getName());
    }

}
