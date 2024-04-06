package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.StatisticsDto;
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
                .build();
    }

    public static Statistics convertDtoToEntity(StatisticsDto source)
    {
        return Statistics.builder()
                .assists(source.getAssists())
                .deaths(source.getDeaths())
                .kills(source.getKills())
                .networth(source.getNetworth())
                .build();
    }
}
