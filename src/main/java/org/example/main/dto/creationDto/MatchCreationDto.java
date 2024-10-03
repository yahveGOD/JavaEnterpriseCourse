package org.example.main.dto.creationDto;

import lombok.*;

import java.sql.Time;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatchCreationDto {
    private Time duration;
    private String victorySide;
    private Long radiantKills;
    private Long direKills;
}
