package org.example.main.dto;

import lombok.*;
import org.example.main.dto.MatchDto;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplayDto {
    private long id;
    private int steamApiMatchReplayKey;
    private MatchDto match;
}
