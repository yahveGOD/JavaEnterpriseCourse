package org.example.main.service;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.dto.MatchDto;
import org.example.main.dto.ReplayDto;
import org.example.main.dto.creationDto.MatchCreationDto;
import org.example.main.dto.creationDto.ReplayCreationDto;
import org.example.main.entity.Match;
import org.example.main.entity.Replay;
import org.example.main.mapper.MatchDtoMapper;
import org.example.main.mapper.ReplayDtoMapper;
import org.example.main.repository.MatchRepository;
import org.example.main.repository.ReplayRepository;
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

import javax.swing.*;
import java.sql.Time;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = { LiquibaseConfig.class, HibernateConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class ReplayServiceTest {

    @InjectMocks
    private ReplayService replayService;
    @Mock
    private ReplayRepository replayRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest(){

        Replay replay = Replay.builder()
                .id(1L)
                .match(Match.builder()
                        .id(1L)
                        .radiantKills(11L)
                        .build())
                .steamApiMatchReplayKey(1231231232L)
                .build();
        Replay replay1 = Replay.builder()
                .id(2L)
                .match(Match.builder()
                        .id(2L)
                        .radiantKills(11L)
                        .build())
                .steamApiMatchReplayKey(123232L)
                .build();
        Mockito.when(replayRepository.findAll()).thenReturn(List.of(replay1,replay));

        List<ReplayDto> actualDtos = replayService.findAll();

        Mockito.verify(replayRepository, Mockito.times(1)).findAll();
        Assertions.assertFalse(actualDtos.isEmpty());
        Assertions.assertNotNull(actualDtos);
        Assertions.assertEquals(2, actualDtos.size());
    }

    @Test
    public void findByIdTest(){
        Replay replay = Replay.builder()
                .id(1L)
                .match(Match.builder()
                        .id(1L)
                        .radiantKills(11L)
                        .build())
                .steamApiMatchReplayKey(1231231232L)
                .build();

        Mockito.when(replayRepository.findById(replay.getId())).thenReturn(replay);

        ReplayDto expected = ReplayDtoMapper.convertEntityToDto(replay);
        ReplayDto actual = replayService.findById(replay.getId());

        Mockito.verify(replayRepository, Mockito.times(1)).findById(Mockito.any());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getSteamApiMatchReplayKey(), actual.getSteamApiMatchReplayKey());
    }

    @Test
    public void saveTest(){
        ReplayCreationDto replayDto = ReplayCreationDto.builder()
                .steamApiMatchReplayKey(1231231232L)
                .build();

        Replay replay = ReplayDtoMapper.buildEntity(replayDto);

        Mockito.when(replayRepository.create(Mockito.any(Replay.class))).thenReturn(replay);

        replayService.addReplay(replayDto);

        Mockito.verify(replayRepository, Mockito.times(1)).create(Mockito.any(Replay.class));
    }

    @Test
    public void updateTest() {
        Replay replay = Replay.builder()
                .steamApiMatchReplayKey(1231231232L)
                .build();
        ReplayDto dto = new ReplayDto();
        dto.setSteamApiMatchReplayKey(1000L);

        Mockito.when(replayRepository.findById(replay.getId())).thenReturn(replay);

        replayService.update(replay.getId(), dto);

        Mockito.verify(replayRepository, Mockito.times(1)).update(Mockito.any(Replay.class));
    }
}
