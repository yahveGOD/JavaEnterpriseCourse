package org.example.main.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private long id;
    private String name;
    private float winRate;
    private float useRate;
    private int boughtTimes;
    private String description;
    private String abilityDescription;
}
