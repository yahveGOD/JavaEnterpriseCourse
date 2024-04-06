package org.example.main.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbilityDto {
    private long id;
    private HeroDto hero;
    private String name;
    private String description;
    private String damageType;
    private int fixedDamage;
    private boolean isPassive;
}
