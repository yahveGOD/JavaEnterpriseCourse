package org.example.main.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameMode {
    private long id;
    private String name;
    private String description;
    private boolean isEvent;
    private int numberOfPLayers;
}
