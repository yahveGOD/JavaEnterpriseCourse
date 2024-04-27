package org.example.main.repository;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.entity.Ability;
import org.example.main.entity.GameMode;
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
public class GameModeRepositoryTests {

    @Autowired
    private GameModeRepository gameModeRepository;

    @Test
    public void givenGameMode_whenFindByName_thenOk(){
        GameMode gameMode = GameMode.builder()
                .name("zxcqwe")
                .description("qwerty")
                .isEvent(false)
                .numberOfPLayers((short) 10)
                .build();
        GameMode gameMode1 = GameMode.builder()
                .name("zxcqwe")
                .description("qwerty")
                .isEvent(true)
                .numberOfPLayers((short) 9)
                .build();

        gameModeRepository.create(gameMode);
        gameModeRepository.create(gameMode1);

        List<GameMode> testGameMode = gameModeRepository.findGameModesByName(gameMode1.getName());

        assertEquals(2,testGameMode.size());
        assertEquals(testGameMode.stream().allMatch(t -> t.getName().equals(gameMode1.getName())),gameMode1.getName() == gameMode1.getName());
    }

    @Test
    public void givenAbility_whenFindByNumberOfPlayers_thenOk(){
        GameMode gameMode = GameMode.builder()
                .name("zxcqwe")
                .description("qwerty")
                .isEvent(false)
                .numberOfPLayers((short) 10)
                .build();
        GameMode gameMode1 = GameMode.builder()
                .name("zxcqwe")
                .description("qwerty")
                .isEvent(true)
                .numberOfPLayers((short) 9)
                .build();

        gameModeRepository.create(gameMode);
        gameModeRepository.create(gameMode1);

        List<GameMode> testGameMode = gameModeRepository.findGameModesByNumberOfPLayers(gameMode1.getNumberOfPLayers());

        assertEquals(1,testGameMode.size());
        assertEquals(testGameMode.stream().allMatch(t -> t.getNumberOfPLayers().equals(gameMode1.getNumberOfPLayers())),true);
    }
}
