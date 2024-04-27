package org.example.main.repository;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.entity.GameMode;
import org.example.main.entity.Item;
import org.example.main.entity.Match;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConfig.class, LiquibaseConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class MatchRepositoryTests {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private GameModeRepository gameModeRepository;

    @Test
    public void givenMatch_whenFindByRadiantKills_thenOk() {
        Match match = Match.builder()
                .gameMode(GameMode.builder()
                        .id(1L)
                        .build())
                .direKills(123L)
                .duration(Time.valueOf("00:29:42"))
                .radiantKills(123L)
                .victorySide("zxc")
                .build();

        Match match1 = Match.builder()
                .direKills(123L)
                .gameMode(GameMode.builder()
                        .id(1L)
                        .build())
                .duration(Time.valueOf("00:29:42"))
                .radiantKills(123L)
                .victorySide("zxcqwe")
                .build();

        matchRepository.create(match1);
        matchRepository.create(match);
        List<Match> testMatch = matchRepository.findMatchesByRadiantKills(match1.getRadiantKills());

        assertEquals(2, testMatch.size());
        assertEquals(testMatch.stream().allMatch(t -> t.getRadiantKills().equals(match1.getRadiantKills())), true);
    }

    @Test
    public void givenMatch_whenFetchMatchesWithLazyAssociationsCriteriaApi_thenOk() {
        GameMode gameMode = gameModeRepository.findById(1L);

        Match match = Match.builder()
                .direKills(1L)
                .radiantKills(1L)
                .victorySide("Dire")
                .duration(Time.valueOf("00:29:42"))
                .gameMode(gameMode)
                .build();

        Match match1 = Match.builder()
                .direKills(1L)
                .radiantKills(22L)
                .duration(Time.valueOf("00:29:42"))
                .victorySide("Radiant")
                .gameMode(gameMode)
                .build();

        matchRepository.create(match);
        matchRepository.create(match1);

        List<Match> testMatch = matchRepository.fetchMatchesWithLazyAssociationsCriteriaApi();

        Assert.assertNotNull(testMatch);
        assertEquals(4,testMatch.size());
        assertEquals(gameMode.getName(),testMatch.get(2).getGameMode().getName());
        assertEquals(gameMode.getName(),testMatch.get(3).getGameMode().getName());
    }

    @Test
    public void givenMatch_whenFetchMatchesWithLazyAssociationsEntityGraph_thenOk() {
        GameMode gameMode = GameMode.builder()
                .numberOfPLayers((short) 10)
                .id(2L)
                .isEvent(true)
                .name("zxc")
                .description("qwetry")
                .build();
        Match match = Match.builder()
                .direKills(123L)
                .duration(Time.valueOf("00:29:42"))
                .radiantKills(123L)
                .victorySide("zxc")
                .gameMode(gameMode)
                .build();

        Match match1 = Match.builder()
                .direKills(123L)
                .duration(Time.valueOf("00:29:42"))
                .radiantKills(123L)
                .victorySide("zxcqwe")
                .gameMode(gameMode)
                .build();

        matchRepository.create(match);
        matchRepository.create(match1);

        List<Match> testMatch = matchRepository.fetchMatchesWithLazyAssociationsEntityGraph();

        Assert.assertNotNull(testMatch);
        assertEquals(4,testMatch.size());
        assertEquals(gameMode.getName(),testMatch.get(2).getGameMode().getName());
        assertEquals(gameMode.getName(),testMatch.get(3).getGameMode().getName());
    }


    @Test
    public void givenMatch_whenFetchMatchesWithLazyAssociationsJPQL_thenOk() {
        GameMode gameMode = GameMode.builder()
                .numberOfPLayers((short) 10)
                .id(2L)
                .isEvent(true)
                .name("zxc")
                .description("qwetry")
                .build();
        Match match = Match.builder()
                .direKills(123L)
                .duration(Time.valueOf("00:29:42"))
                .radiantKills(123L)
                .victorySide("zxc")
                .gameMode(gameMode)
                .build();

        Match match1 = Match.builder()
                .direKills(123L)
                .duration(Time.valueOf("00:29:42"))
                .radiantKills(123L)
                .victorySide("zxcqwe")
                .gameMode(gameMode)
                .build();

        matchRepository.create(match);
        matchRepository.create(match1);

        List<Match> testMatch = matchRepository.fetchMatchesWithLazyAssociationsJPQL();

        Assert.assertNotNull(testMatch);
        assertEquals(4,testMatch.size());
        assertEquals(gameMode.getName(),testMatch.get(2).getGameMode().getName());
        assertEquals(gameMode.getName(),testMatch.get(3).getGameMode().getName());
    }

}
