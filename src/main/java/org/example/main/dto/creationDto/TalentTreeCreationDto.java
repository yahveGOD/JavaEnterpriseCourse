package org.example.main.dto.creationDto;

import lombok.*;
import org.example.main.entity.TalentBranch;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TalentTreeCreationDto {
    private int levelRequired;
    private TalentBranch talentBranch;
}
