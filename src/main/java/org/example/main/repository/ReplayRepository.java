package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.Match;
import org.example.main.entity.Replay;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReplayRepository {
    private MatchRepository mr = new MatchRepository();
    @Getter
    private List<Replay> replayList;

    public ReplayRepository() {
        replayList = new ArrayList<>();
        Replay replay1 = new Replay(0, 1231211, mr.getMatchList().get(0));
        Replay replay2 = new Replay(1, 1231111, mr.getMatchList().get(1));
        replayList.add(replay1);
        replayList.add(replay2);
    }
}
