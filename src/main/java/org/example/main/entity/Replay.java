package org.example.main.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Replay {
    private long id;
    private int steamApiMatchReplayKey;
    private Match match;
}
