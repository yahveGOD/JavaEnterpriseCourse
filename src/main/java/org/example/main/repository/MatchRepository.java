package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.GameMode;
import org.example.main.entity.Match;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MatchRepository extends AbstractRepository<Match>{

    public MatchRepository() {
        save(Match.builder()
                .direKills(123)
                .duration(Duration.ofHours(0).plusMinutes(30).plusSeconds(45))
                .radiantKills(123)
                .victorySide("zxc")
                .build());
        save(Match.builder()
                .direKills(555)
                .duration(Duration.ofHours(0).plusMinutes(30).plusSeconds(45))
                .radiantKills(666)
                .victorySide("qwe")
                .build());
    }
}
