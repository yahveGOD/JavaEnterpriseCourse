package org.example.main.repository;

import jakarta.annotation.Resource;
import jakarta.persistence.PersistenceContext;
import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.entity.Ability;
import org.example.main.entity.Hero;

import org.hibernate.annotations.Source;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConfig.class, LiquibaseConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class AbstractRepositoryTests {

    @Autowired
    private AbilityRepository abilityRepository;

    @Test
    public void givenAbility_whenCreate_thenOk(){
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

        abilityRepository.create(ability);

        Ability testAbility = abilityRepository.findById(ability.getId());

        Assert.assertNotNull(testAbility);
        assertEquals(ability.getName(), testAbility.getName());
    }

    @Test
    public void givenAbilities_whenFindAll_thenOk(){
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

        abilityRepository.create(ability);

        List<Ability> testAbilities = abilityRepository.findAll();

        Assert.assertNotNull(testAbilities);
        Assert.assertFalse(testAbilities.isEmpty());
    }

    @Test
    public void givenAbility_whenDelete_thenOk(){
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

        abilityRepository.create(ability);

        Ability testAbility = abilityRepository.findById(ability.getId());

        Assert.assertNotNull(testAbility);
        Assert.assertEquals(ability.getName(), testAbility.getName());

        abilityRepository.deleteById(ability.getId());

        testAbility = abilityRepository.findById(ability.getId());

        Assert.assertNull(testAbility);
    }

    @Test
    public void givenAbility_whenUpdate_thenOk(){
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

        abilityRepository.create(ability);

        String newName = "qwert";

        ability.setName(newName);
        abilityRepository.update(ability);

        Ability testAbility = abilityRepository.findById(ability.getId());

        Assert.assertNotNull(testAbility);
        Assert.assertEquals(testAbility.getName(), newName);
        Assert.assertEquals(testAbility.getName(),ability.getName());
    }

}
