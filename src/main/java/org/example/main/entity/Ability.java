package org.example.main.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ability {
    private long id;
    private  Hero hero;
    private String name;
    private String description;
    private String damageType;
    private int fixedDamage;
    private boolean isPassive;
}
