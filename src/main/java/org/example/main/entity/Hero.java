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
@AllArgsConstructor
@Table(name="Hero")
public class Hero extends BaseEntity {
    @OneToMany(mappedBy = "hero", fetch = FetchType.LAZY)
    private List<Ability> abilities;

    @ManyToMany(mappedBy = "heroes", fetch = FetchType.LAZY)
    private List<PickedHero> pickedHeroes;

    @Column(name = "name")
    private String name;

    @Column(name = "win_rate")
    private Float winRate;

    @Column(name = "pick_rate")
    private Float pickRate;

    @Column(name = "picked_times")
    private Integer pickedTimes;

    @Column(name = "strength")
    private Integer strength;

    @Column(name = "agility")
    private Integer agility;

    @Column(name = "intelligence")
    private Integer intelligence;
}
