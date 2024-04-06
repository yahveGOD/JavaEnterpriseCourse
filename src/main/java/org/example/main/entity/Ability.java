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
public class Ability extends BaseEntity {
    private  Hero hero;
    private String name;
    private String description;
    private String damageType;
    private int fixedDamage;
    private boolean isPassive;
}
