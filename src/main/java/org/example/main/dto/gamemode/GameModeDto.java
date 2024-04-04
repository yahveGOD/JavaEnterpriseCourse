package org.example.main.dto.gamemode;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameModeDto {
    private long uuid;
    private String name;
    private String description;
    private boolean isEvent;
    private int numberOfPLayers;
}
