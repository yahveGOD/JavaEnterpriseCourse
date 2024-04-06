package org.example.main.dto;

import lombok.*;
import org.example.main.dto.HeroDto;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TalentTreeDto {
    private long id;
    private HeroDto hero;
    private int levelRequired;
    private String talentLeft;
    private String talentRight;
}
