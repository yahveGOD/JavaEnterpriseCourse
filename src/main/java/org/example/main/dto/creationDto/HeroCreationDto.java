package org.example.main.dto.creationDto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeroCreationDto {

    private String name;
    private float winRate;
    private float pickRate;
    private int pickedTimes;
    private int strength;
    private int agility;
    private int intelligence;
}
