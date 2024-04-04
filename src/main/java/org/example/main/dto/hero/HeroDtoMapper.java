package org.example.main.dto.hero;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.example.main.dto.hero.HeroDto;
import org.example.main.entity.Hero;

@UtilityClass
public class HeroDtoMapper {
    public static HeroDto convertEntityToDto(Hero source)
    {
        return HeroDto.builder()
                .agility(source.getAgility())
                .intelligence(source.getIntelligence())
                .name(source.getName())
                .pickedTimes(source.getPickedTimes())
                .pickRate(source.getPickRate())
                .strength(source.getStrength())
                .winRate(source.getWinRate())
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
                .build();
    }
}
