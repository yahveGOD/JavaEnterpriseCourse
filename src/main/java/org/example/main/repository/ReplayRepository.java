package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.Match;
import org.example.main.entity.Replay;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReplayRepository extends AbstractRepository<Replay> {
    public ReplayRepository() {
        save(Replay.builder()
                .steamApiMatchReplayKey(123123)
                .build());
    }
}
