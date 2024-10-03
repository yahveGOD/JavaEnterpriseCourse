package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.AbilityDto;
import org.example.main.dto.PickedHeroDto;
import org.example.main.dto.creationDto.HeroCreationDto;
import org.example.main.dto.HeroDto;
import org.example.main.entity.Ability;
import org.example.main.entity.Hero;
import org.example.main.entity.PickedHero;

import java.util.stream.Collectors;

@UtilityClass
public class HeroDtoMapper {
    public static HeroDto convertEntityToDto(Hero source)
    {
        return HeroDto.builder()
                .id(source.getId())
                .agility(source.getAgility())
                .intelligence(source.getIntelligence())
                .name(source.getName())
                .pickedTimes(source.getPickedTimes())
                .pickRate(source.getPickRate())
                .strength(source.getStrength())
                .winRate(source.getWinRate())
                .pickedHeroes(source.getPickedHeroes().stream()
                        .map(pickedHero -> PickedHeroDto.builder()
                                .pickedHeroId(pickedHero.getPickedHeroId())
                                .build())
                        .toList())
                .abilities(source.getAbilities().stream()
                        .map(ability -> AbilityDto.builder()
                                .id(ability.getId())
                                .name(ability.getName())
                                .build())
                        .toList())
                .build();
    }

    public static Hero convertDtoToEntity(HeroDto source)
    {
        return Hero.builder()
                .agility(source.getAgility())
                .intelligence(source.getIntelligence())
                .name(source.getName())
                .pickedTimes(source.getPickedTimes())
                .pickRate(source.getPickRate())
                .strength(source.getStrength())
                .winRate(source.getWinRate())
                .pickedHeroes(source.getPickedHeroes().stream()
                        .map(pickedHeroDto -> PickedHero.builder()
                                .pickedHeroId(pickedHeroDto.getPickedHeroId())
                                .build())
                        .toList())
                .abilities(source.getAbilities().stream()
                        .map(abilityDto -> Ability.builder()
                                .id(abilityDto.getId())
                                .name(abilityDto.getName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public static Hero buildEntity(HeroCreationDto source){
        return Hero.builder()
                .agility(source.getAgility())
                .intelligence(source.getIntelligence())
                .name(source.getName())
                .pickedTimes(source.getPickedTimes())
                .pickRate(source.getPickRate())
                .strength(source.getStrength())
                .winRate(source.getWinRate())
                .build();
    }
}
