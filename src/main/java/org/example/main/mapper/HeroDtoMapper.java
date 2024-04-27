package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.AbilityDto;
import org.example.main.dto.HeroDto;
import org.example.main.entity.Hero;

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
                .pickedHeroes(source.getPickedHeroes().stream().map(PickedHeroDtoMapper::convertEntityToDto).toList())
                .abilities(source.getAbilities().stream().map(AbilityDtoMapper::convertEntityToDto).toList())
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
                .pickedHeroes(source.getPickedHeroes().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList())
                .abilities(source.getAbilities().stream().map(AbilityDtoMapper::convertDtoToEntity).toList())
                .build();
    }
}
