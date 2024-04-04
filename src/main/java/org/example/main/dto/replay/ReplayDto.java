package org.example.main.dto.replay;

import lombok.*;
import org.example.main.dto.match.MatchDto;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplayDto {
    private long uuid;
    private int steamApiMatchReplayKey;
    private MatchDto match;
}
