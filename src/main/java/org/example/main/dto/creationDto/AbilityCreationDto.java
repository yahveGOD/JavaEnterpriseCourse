package org.example.main.dto.creationDto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbilityCreationDto {
    private String name;
    private String description;
    private String damageType;
    private Integer fixedDamage;
    private Boolean isPassive;
}
