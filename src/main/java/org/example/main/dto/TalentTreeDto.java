package org.example.main.dto;

import lombok.*;
import org.example.main.dto.HeroDto;
import org.example.main.entity.TalentBranch;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TalentTreeDto {
    private long id;
    private HeroDto hero;
    private int levelRequired;
    private TalentBranch talentBranch;
}
