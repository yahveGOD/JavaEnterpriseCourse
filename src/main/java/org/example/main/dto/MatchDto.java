package org.example.main.dto;

import lombok.*;
import org.example.main.dto.GameModeDto;

import java.time.Duration;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchDto {
    private long id;
    private Duration duration;
    private String victorySide;
    private GameModeDto gameMode;
    private int radiantKills;
    private int direKills;
}
