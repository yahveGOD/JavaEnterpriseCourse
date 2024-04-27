package org.example.main.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.example.main.entity.Ability;
import org.example.main.entity.PickedHero;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeroDto {
    private long id;
    private String name;
    private float winRate;
    private float pickRate;
    private int pickedTimes;
    private int strength;
    private int agility;
    private int intelligence;
    private List<AbilityDto> abilities;
    private List<PickedHeroDto> pickedHeroes;
}
