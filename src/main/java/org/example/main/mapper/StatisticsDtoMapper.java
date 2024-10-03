package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.PickedHeroDto;
import org.example.main.dto.creationDto.StatisticsCreationDto;
import org.example.main.dto.StatisticsDto;
import org.example.main.entity.PickedHero;
import org.example.main.entity.Statistics;

@UtilityClass
public class StatisticsDtoMapper {
    public static StatisticsDto convertEntityToDto(Statistics source)
    {
        return StatisticsDto.builder()
                .id(source.getId())
                .assists(source.getAssists())
                .deaths(source.getDeaths())
                .kills(source.getKills())
                .networth(source.getNetworth())
                .pickedHeroList(source.getPickedHeroList().stream()
                        .map(pickedHero -> PickedHeroDto.builder()
                                .pickedHeroId(pickedHero.getPickedHeroId())
                                .build())
                        .toList())
                .build();
    }

    public static Statistics convertDtoToEntity(StatisticsDto source)
    {
        return Statistics.builder()
                .assists(source.getAssists())
                .deaths(source.getDeaths())
                .kills(source.getKills())
                .networth(source.getNetworth())
                .pickedHeroList(source.getPickedHeroList().stream()
                        .map(pickedHeroDto -> PickedHero.builder()
                                .pickedHeroId(pickedHeroDto.getPickedHeroId())
                                .build())
                        .toList())
                .build();
    }

    public static Statistics buildEntity(StatisticsCreationDto source){
        return Statistics.builder()
                .networth(source.getNetworth())
                .assists(source.getAssists())
                .kills(source.getKills())
                .deaths(source.getDeaths())
                .build();
    }
}
