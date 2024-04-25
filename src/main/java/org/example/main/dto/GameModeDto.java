package org.example.main.dto;

import lombok.*;
import org.example.main.entity.Match;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameModeDto {
    private Long id;
    private String name;
    private String description;
    private Boolean isEvent;
    private Short numberOfPLayers;
    private List<MatchDto> matches;
}
