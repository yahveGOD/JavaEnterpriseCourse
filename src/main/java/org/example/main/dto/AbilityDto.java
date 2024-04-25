package org.example.main.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbilityDto {
    private Long id;
    private HeroDto hero;
    private String name;
    private String description;
    private String damageType;
    private Integer fixedDamage;
    private Boolean isPassive;
}
