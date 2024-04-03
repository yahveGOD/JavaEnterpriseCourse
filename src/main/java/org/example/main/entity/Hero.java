package org.example.main.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hero {
    private long id;
    private String name;
    private float winRate;
    private float pickRate;
    private int pickedTimes;
    private int strength;
    private int agility;
    private int intelligence;

}
