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
    private Long id;
    private HeroDto hero;
    private Integer levelRequired;
    //private TalentBranch talentBranch;
    private String cells;
}
