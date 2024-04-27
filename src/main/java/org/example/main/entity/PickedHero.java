package org.example.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "picked_hero")
public class PickedHero implements Serializable {
    @EmbeddedId
    private PickedHeroId pickedHeroId;

    @JoinTable(joinColumns = {@JoinColumn(name = "match_id"),@JoinColumn(name = "hero_id")}, inverseJoinColumns = @JoinColumn(name = "id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Hero> heroes;

    @JoinTable(joinColumns = {@JoinColumn(name = "match_id"),@JoinColumn(name = "hero_id")}, inverseJoinColumns = @JoinColumn(name = "id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Match> matches;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "statistics_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Statistics statistics;

    @JoinColumn(name = "inventory_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inventory inventory;
}
