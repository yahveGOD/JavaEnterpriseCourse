package org.example.main.dto.match;

import lombok.*;
import org.example.main.dto.gamemode.GameModeDto;

import java.time.Duration;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchDto {
    private long uuid;
    private Duration duration;
    private String victorySide;
    private GameModeDto gameMode;
    private int radiantKills;
    private int direKills;
}
