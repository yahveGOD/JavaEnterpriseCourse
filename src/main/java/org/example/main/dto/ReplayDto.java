package org.example.main.dto;

import lombok.*;
import org.example.main.entity.Match;
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
