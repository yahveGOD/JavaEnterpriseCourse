package org.example.main.service;

import org.example.main.dto.RoleDto;
import org.example.main.dto.StatisticsDto;
import org.example.main.dto.mapper.RoleDtoMapper;
import org.example.main.dto.mapper.StatisticsDtoMapper;
import org.example.main.entity.Role;
import org.example.main.entity.Statistics;
import org.example.main.repository.StatisticsRepository;

import java.util.List;

public class StatisticsService {
    private final StatisticsRepository statisticsRepository;

    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public List<StatisticsDto> FindAllStats() {
        return statisticsRepository.getStatisticsList().stream().map(StatisticsDtoMapper::convertEntityToDto).toList();
    }

    public void deleteStatistics(int idInList) {
        statisticsRepository.getStatisticsList().remove(idInList);
    }

    public void statisticsEditUpdate(int idInList, StatisticsDto statisticsDto) {
        Statistics statistics = statisticsRepository.getStatisticsList().get(idInList);
        statistics.setId(statisticsDto.getUuid());
        statistics.setDeaths(statisticsDto.getDeaths());
        statistics.setAssists(statisticsDto.getAssists());
        statistics.setKills(statisticsDto.getKills());
        statistics.setNetworth(statisticsDto.getNetworth());
        statisticsRepository.getStatisticsList().set(idInList, statistics);
    }

    public void addStatistics(StatisticsDto statisticsDto) {
        statisticsRepository.getStatisticsList().add(StatisticsDtoMapper.convertDtoToEntity(statisticsDto));
    }
}
