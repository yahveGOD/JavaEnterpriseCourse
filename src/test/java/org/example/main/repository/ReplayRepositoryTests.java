package org.example.main.repository;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.entity.GameMode;
import org.example.main.entity.Match;
import org.example.main.entity.Replay;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConfig.class, LiquibaseConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class ReplayRepositoryTests {

    @Autowired
    private ReplayRepository replayRepository;

    @Autowired
    private MatchRepository matchRepository;
    @Test
    public void givenReplay_whenFetchReplaysWithLazyAssociationsCriteriaApi_thenOk() {
        Match match = Match.builder()
                .direKills(123L)
                .duration(Time.valueOf("00:29:42"))
                .radiantKills(123L)
                .victorySide("zxc")
                .build();
        matchRepository.create(match);

        Replay replay = Replay.builder()
                .match(match)
                .steamApiMatchReplayKey(123123L)
                .build();

        replayRepository.create(replay);

        List<Replay> testReplay = replayRepository.fetchReplaysWithLazyAssociationsJPQL();

        Assert.assertNotNull(testReplay);
        assertEquals(3,testReplay.size());
        assertEquals(match.getRadiantKills(),testReplay.get(2).getMatch().getRadiantKills());
    }

    @Test
    public void givenReplay_whenFindReplaysBySteamApi_thenOk() {

        Match match = Match.builder()
                .direKills(123L)
                .duration(Time.valueOf("00:29:42"))
                .radiantKills(123L)
                .victorySide("zxc")
                .build();
        matchRepository.create(match);

        Match match1 = Match.builder()
                .direKills(123L)
                .duration(Time.valueOf("00:29:42"))
                .radiantKills(123L)
                .victorySide("qwert")
                .build();
        matchRepository.create(match1);


        Replay replay = Replay.builder()
                .steamApiMatchReplayKey(1231312L)
                .match(match)
                .build();
        Replay replay1 = Replay.builder()
                .steamApiMatchReplayKey(111111312L)
                .match(match1)
                .build();

        replayRepository.create(replay);
        replayRepository.create(replay1);

        List<Replay> testReplay = replayRepository.findReplaysBySteamApi(replay1.getSteamApiMatchReplayKey());

        assertEquals(1, testReplay.size());
        assertEquals(testReplay.stream().allMatch(t -> t.getSteamApiMatchReplayKey().equals(replay1.getSteamApiMatchReplayKey())), true);
    }


}
