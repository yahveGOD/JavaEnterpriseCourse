package org.example.main.dto.creationDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemCreationDto {
    private String name;
    private float winRate;
    private float useRate;
    private int boughtTimes;
    private String description;
    private String abilityDescription;
}
