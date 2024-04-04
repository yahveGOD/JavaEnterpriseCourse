package org.example.main.dto.statistics;

import lombok.experimental.UtilityClass;
import org.example.main.dto.statistics.StatisticsDto;
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
                .assists(source.getAssists())
                .deaths(source.getDeaths())
                .kills(source.getKills())
                .networth(source.getNetworth())
                .build();
    }
}
