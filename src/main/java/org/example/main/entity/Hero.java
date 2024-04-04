package org.example.main.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hero extends BaseEntity {
    private String name;
    private float winRate;
    private float pickRate;
    private int pickedTimes;
    private int strength;
    private int agility;
    private int intelligence;
}
