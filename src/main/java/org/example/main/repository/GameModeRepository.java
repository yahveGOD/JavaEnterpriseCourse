package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.GameMode;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameModeRepository {
    @Getter
    private final List<GameMode> gameModeList;

    public GameModeRepository() {
        gameModeList = new ArrayList<>();
        GameMode gameMode1 = new GameMode(0, "hello", "zxc", true, 10);
        GameMode gameMode2 = new GameMode(1, "bye-bye", "qwe", true, 10);
        gameModeList.add(gameMode1);
        gameModeList.add(gameMode2);
    }

}
