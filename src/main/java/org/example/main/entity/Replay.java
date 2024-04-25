package org.example.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "replay")
public class Replay extends BaseEntity {

    @Column(name = "steam_api_match_replay_key")
    private Long steamApiMatchReplayKey;

    @JoinColumn(name = "match_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Match match;
}
