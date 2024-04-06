package org.example.main.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeroDto {
    private long id;
    private String name;
    private float winRate;
    private float pickRate;
    private int pickedTimes;
    private int strength;
    private int agility;
    private int intelligence;
}
