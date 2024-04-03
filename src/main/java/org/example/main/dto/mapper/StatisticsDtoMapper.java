package org.example.main.dto.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.StatisticsDto;
import org.example.main.entity.Statistics;

@UtilityClass
public class StatisticsDtoMapper {
    public static StatisticsDto convertEntityToDto(Statistics source)
    {
        return StatisticsDto.builder()
                .uuid(source.getId())
                .assists(source.getAssists())
                .deaths(source.getDeaths())
                .kills(source.getKills())
                .networth(source.getNetworth())
                .build();
    }

    public static Statistics convertDtoToEntity(StatisticsDto source)
    {
        return Statistics.builder()
                .id(source.getUuid())
                .assists(source.getAssists())
                .deaths(source.getDeaths())
                .kills(source.getKills())
                .networth(source.getNetworth())
                .build();
    }
}
