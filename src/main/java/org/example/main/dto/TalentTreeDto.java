package org.example.main.dto;

import lombok.*;
import org.example.main.entity.Hero;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TalentTreeDto {
    private long uuid;
    private HeroDto hero;
    private int levelRequired;
    private String talentLeft;
    private String talentRight;
}
