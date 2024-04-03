package org.example.main.entity;

import lombok.*;

import java.time.Duration;
import java.time.LocalTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    private long id;
    private Duration duration;
    private String victorySide;
    private GameMode gameMode;
    private int radiantKills;
    private int direKills;
}
