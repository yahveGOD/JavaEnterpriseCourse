package org.example.main.service;

import lombok.RequiredArgsConstructor;
import org.example.main.dto.ItemDto;
import org.example.main.dto.StatisticsDto;
import org.example.main.dto.creationDto.StatisticsCreationDto;
import org.example.main.mapper.ItemDtoMapper;
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

    public StatisticsDto findById(Long id) {
        return StatisticsDtoMapper.convertEntityToDto(statisticsRepository.findById(id));
    }

    public void delete(Long id) {
        statisticsRepository.deleteById(id);
    }

    public void update(Long id, StatisticsDto statisticsDto) {
        Statistics statistics = statisticsRepository.findById(id);
        if (statisticsDto.getDeaths() >= 0)
            statistics.setDeaths(statisticsDto.getDeaths());
        if (statisticsDto.getAssists() >= 0)
            statistics.setAssists(statisticsDto.getAssists());
        if (statisticsDto.getKills() >= 0)
            statistics.setKills(statisticsDto.getKills());
        if (statisticsDto.getNetworth() >= 0)
            statistics.setNetworth(statisticsDto.getNetworth());
        if (statisticsDto.getPickedHeroList() != null)
            statistics.setPickedHeroList(statisticsDto.getPickedHeroList().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList());

        statisticsRepository.update(statistics);
    }

    public void addStatistics(StatisticsDto statisticsDto) {
        statisticsRepository.create(StatisticsDtoMapper.convertDtoToEntity(statisticsDto));
    }

    public void addStatistics(StatisticsCreationDto statisticsDto) {
        statisticsRepository.create(StatisticsDtoMapper.buildEntity(statisticsDto));
    }
}
