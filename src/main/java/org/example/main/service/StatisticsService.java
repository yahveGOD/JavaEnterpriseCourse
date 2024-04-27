package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.StatisticsDto;
import org.example.main.mapper.PickedHeroDtoMapper;
import org.example.main.mapper.StatisticsDtoMapper;
import org.example.main.entity.Statistics;
import org.example.main.repository.StatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;

    public List<StatisticsDto> findAll() {
        return statisticsRepository.findAll().stream().map(StatisticsDtoMapper::convertEntityToDto).toList();
    }

    public void delete(Long id) {
        statisticsRepository.deleteById(id);
    }

    public void update(Long id, StatisticsDto statisticsDto) {
        Statistics statistics = statisticsRepository.findById(id);

        statistics.setDeaths(statisticsDto.getDeaths());
        statistics.setAssists(statisticsDto.getAssists());
        statistics.setKills(statisticsDto.getKills());
        statistics.setNetworth(statisticsDto.getNetworth());
        statistics.setPickedHeroList(statisticsDto.getPickedHeroList().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList());

        statisticsRepository.update(statistics);
    }

    public void addStatistics(StatisticsDto statisticsDto) {
        statisticsRepository.create(StatisticsDtoMapper.convertDtoToEntity(statisticsDto));
    }
}
