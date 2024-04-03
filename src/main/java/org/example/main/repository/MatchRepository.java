package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.GameMode;
import org.example.main.entity.Match;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MatchRepository {
    private GameModeRepository gmp = new GameModeRepository();
    @Getter
    private List<Match> matchList;

    public MatchRepository() {
        matchList = new ArrayList<>();
        Match match1 = new Match(0, Duration.ofHours(0).plusMinutes(30).plusSeconds(45),"Lol",gmp.getGameModeList().get(0),100,150);

        Match match2 = new Match(1, Duration.ofHours(1).plusMinutes(30).plusSeconds(45),"Lolzxc",gmp.getGameModeList().get(0),255,471);
        matchList.add(match1);
        matchList.add(match2);
    }
}
