package org.example.main.dto.talentTree;

import lombok.*;
import org.example.main.dto.hero.HeroDto;

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
