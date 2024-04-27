package org.example.main.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "duration")
    private Time duration;

    @Column(name = "victory_side")
    private String victorySide;

    @JoinColumn(name = "game_mode_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private GameMode gameMode;

    @Column(name = "radiant_kills")
    private Long radiantKills;

    @Column(name = "dire_kills")
    private Long direKills;

    @JoinTable(
            name = "matches_history",
            joinColumns = { @JoinColumn(name = "match_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;

    @OneToOne(mappedBy = "match",fetch = FetchType.LAZY)
    private Replay replay;

    @ManyToMany(mappedBy = "matches",fetch = FetchType.LAZY)
    private List<PickedHero> pickedHero;
}
