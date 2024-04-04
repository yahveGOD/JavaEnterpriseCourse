package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.Ability;
import org.example.main.entity.GameMode;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameModeRepository extends AbstractRepository<GameMode>{

    public GameModeRepository() {
        save(GameMode.builder()
                .name("123")
                .description("lol")
                .isEvent(true)
                .numberOfPLayers(3)
                .build());

        save(GameMode.builder()
                .name("567")
                .description("zxc")
                .isEvent(true)
                .numberOfPLayers(17)
                .build());
    }
}
