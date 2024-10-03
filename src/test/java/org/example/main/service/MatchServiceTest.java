package org.example.main.service;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.dto.GameModeDto;
import org.example.main.dto.ReplayDto;
import org.example.main.dto.creationDto.ItemCreationDto;
import org.example.main.dto.ItemDto;
import org.example.main.dto.MatchDto;
import org.example.main.dto.creationDto.MatchCreationDto;
import org.example.main.entity.*;
import org.example.main.mapper.ItemDtoMapper;
import org.example.main.mapper.MatchDtoMapper;
import org.example.main.repository.MatchRepository;
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

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = { LiquibaseConfig.class, HibernateConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class MatchServiceTest {

    @InjectMocks
    private MatchService matchService;
    @Mock
    private MatchRepository matchRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest(){

        Match match = Match.builder()
                .id(1L)
                .gameMode(GameMode.builder()
                        .id(1L)
                        .name("zxc")
                        .build())
                .replay(Replay.builder()
                        .id(1L)
                        .steamApiMatchReplayKey(1231232L)
                        .build())
                .users(new ArrayList<>())
                .pickedHero(new ArrayList<>())
                .victorySide("zxc")
                .radiantKills(1L)
                .direKills(12L)
                .duration(Time.valueOf("00:29:42"))
                .build();
        Match match1 = Match.builder()
                .id(2L)
                .gameMode(GameMode.builder()
                        .id(2L)
                        .name("zxc")
                        .build())
                .replay(Replay.builder()
                        .id(2L)
                        .steamApiMatchReplayKey(1231232L)
                        .build())
                .users(new ArrayList<>())
                .pickedHero(new ArrayList<>())
                .victorySide("qwe")
                .radiantKills(1L)
                .direKills(12L)
                .duration(Time.valueOf("00:29:42"))
                .build();
        Mockito.when(matchRepository.findAll()).thenReturn(List.of(match1,match));

        List<MatchDto> actualDtos = matchService.findAll();

        Mockito.verify(matchRepository, Mockito.times(1)).findAll();
        Assertions.assertFalse(actualDtos.isEmpty());
        Assertions.assertNotNull(actualDtos);
        Assertions.assertEquals(2, actualDtos.size());
    }

    @Test
    public void findByIdTest(){
        Match match = Match.builder()
                .id(1L)
                .gameMode(GameMode.builder()
                        .id(1L)
                        .name("zxc")
                        .build())
                .replay(Replay.builder()
                        .id(1L)
                        .steamApiMatchReplayKey(1231232L)
                        .build())
                .users(new ArrayList<>())
                .pickedHero(new ArrayList<>())
                .victorySide("zxc")
                .radiantKills(1L)
                .direKills(12L)
                .duration(Time.valueOf("00:29:42"))
                .build();

        Mockito.when(matchRepository.findById(match.getId())).thenReturn(match);

        MatchDto expected = MatchDtoMapper.convertEntityToDto(match);
        MatchDto actual = matchService.findById(match.getId());

        Mockito.verify(matchRepository, Mockito.times(1)).findById(Mockito.any());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getRadiantKills(), actual.getRadiantKills());
    }

    @Test
    public void saveTest(){
        MatchCreationDto matchDto = MatchCreationDto.builder()
                .victorySide("zxc")
                .radiantKills(1L)
                .direKills(12L)
                .duration(Time.valueOf("00:29:42"))
                .build();

        Match match = MatchDtoMapper.buildEntity(matchDto);

        Mockito.when(matchRepository.create(Mockito.any(Match.class))).thenReturn(match);

        matchService.addMatch(matchDto);

        Mockito.verify(matchRepository, Mockito.times(1)).create(Mockito.any(Match.class));
    }

    @Test
    public void updateTest() {
        Match match = Match.builder()
                .victorySide("zxc")
                .radiantKills(1L)
                .direKills(12L)
                .duration(Time.valueOf("00:29:42"))
                .build();
        MatchDto dto = new MatchDto();
        dto.setDireKills(1000L);
        Mockito.when(matchRepository.findById(match.getId())).thenReturn(match);

        matchService.update(match.getId(), dto);

        Mockito.verify(matchRepository, Mockito.times(1)).update(Mockito.any(Match.class));
    }
}
