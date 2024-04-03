package org.example.main.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private long uuid;
    private String name;
    private float winRate;
    private float useRate;
    private int boughtTimes;
    private String description;
    private String abilityDescription;
}
