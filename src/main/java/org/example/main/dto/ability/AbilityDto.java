package org.example.main.dto.ability;

import lombok.*;
import org.example.main.dto.hero.HeroDto;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbilityDto {
    private long uuid;
    private HeroDto hero;
    private String name;
    private String description;
    private String damageType;
    private int fixedDamage;
    private boolean isPassive;
}
