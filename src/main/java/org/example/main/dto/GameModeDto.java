package org.example.main.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameModeDto {
    private long id;
    private String name;
    private String description;
    private boolean isEvent;
    private int numberOfPLayers;
}
