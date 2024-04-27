package org.example.main.dto;

import lombok.*;
import org.example.main.dto.MatchDto;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplayDto {
    private Long id;
    private Long steamApiMatchReplayKey;
    private MatchDto match;
}
