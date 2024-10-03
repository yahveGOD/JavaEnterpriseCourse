package org.example.main.dto.creationDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameModeCreationDto {
    private String name;
    private String description;
    private Boolean isEvent;
    private Short numberOfPLayers;
}
