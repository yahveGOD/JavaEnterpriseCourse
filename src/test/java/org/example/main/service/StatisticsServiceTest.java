package org.example.main.service;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.dto.RoleDto;
import org.example.main.dto.StatisticsDto;
import org.example.main.dto.creationDto.RoleCreationDto;
import org.example.main.dto.creationDto.StatisticsCreationDto;
import org.example.main.entity.Role;
import org.example.main.entity.Statistics;
import org.example.main.mapper.RoleDtoMapper;
import org.example.main.mapper.StatisticsDtoMapper;
import org.example.main.repository.RoleRepository;
import org.example.main.repository.StatisticsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = { LiquibaseConfig.class, HibernateConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class StatisticsServiceTest {
    @InjectMocks
    private StatisticsService statisticsService;
    @Mock
    private StatisticsRepository statisticsRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest(){

        Statistics statistics = Statistics.builder()
                .id(1L)
                .pickedHeroList(new ArrayList<>())
                .deaths(11)
                .kills(1)
                .assists(1)
                .networth(123)
                .build();
        Statistics statistics1 = Statistics.builder()
                .id(2L)
                .pickedHeroList(new ArrayList<>())
                .deaths(111)
                .kills(1)
                .assists(1)
                .networth(123)
                .build();
        Mockito.when(statisticsRepository.findAll()).thenReturn(List.of(statistics1,statistics));

        List<StatisticsDto> actualDtos = statisticsService.findAll();

        Mockito.verify(statisticsRepository, Mockito.times(1)).findAll();
        Assertions.assertFalse(actualDtos.isEmpty());
        Assertions.assertNotNull(actualDtos);
        Assertions.assertEquals(2, actualDtos.size());
    }

    @Test
    public void findByIdTest(){
        Statistics statistics = Statistics.builder()
                .id(1L)
                .pickedHeroList(new ArrayList<>())
                .deaths(11)
                .kills(1)
                .assists(1)
                .networth(123)
                .build();

        Mockito.when(statisticsRepository.findById(statistics.getId())).thenReturn(statistics);

        StatisticsDto expected = StatisticsDtoMapper.convertEntityToDto(statistics);
        StatisticsDto actual = statisticsService.findById(statistics.getId());

        Mockito.verify(statisticsRepository, Mockito.times(1)).findById(Mockito.any());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getAssists(), actual.getAssists());
    }

    @Test
    public void saveTest(){
        StatisticsCreationDto statisticsDto = StatisticsCreationDto.builder()
                .deaths(11)
                .kills(1)
                .assists(1)
                .networth(123)
                .build();
        Statistics statistics = StatisticsDtoMapper.buildEntity(statisticsDto);

        Mockito.when(statisticsRepository.create(Mockito.any(Statistics.class))).thenReturn(statistics);

        statisticsService.addStatistics(statisticsDto);

        Mockito.verify(statisticsRepository, Mockito.times(1)).create(Mockito.any(Statistics.class));
    }

    @Test
    public void updateTest() {
        Statistics statistics = Statistics.builder()
                .deaths(11)
                .kills(1)
                .assists(1)
                .networth(123)
                .build();
        StatisticsDto dto = new StatisticsDto();
        dto.setAssists(1111);

        Mockito.when(statisticsRepository.findById(statistics.getId())).thenReturn(statistics);

        statisticsService.update(statistics.getId(), dto);

        Mockito.verify(statisticsRepository, Mockito.times(1)).update(Mockito.any(Statistics.class));
    }
}
