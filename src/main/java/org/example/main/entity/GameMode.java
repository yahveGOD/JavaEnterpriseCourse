package org.example.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name="game_mode")
public class GameMode{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_event")
    private Boolean isEvent;

    @Column(name = "number_of_players")
    private Short numberOfPLayers;

    @OneToMany(mappedBy = "gameMode", fetch = FetchType.LAZY)
    private List<Match> matches;
}
