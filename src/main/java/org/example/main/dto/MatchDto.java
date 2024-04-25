package org.example.main.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.example.main.dto.GameModeDto;
import org.example.main.entity.Replay;
import org.example.main.entity.User;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchDto {
    private Long id;
    private Time duration;
    private String victorySide;
    private GameModeDto gameMode;
    private Long radiantKills;
    private Long direKills;
    private List<UserDto> users;
    private ReplayDto replay;
}
