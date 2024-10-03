package org.example.main.service;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.dto.creationDto.GameModeCreationDto;
import org.example.main.dto.GameModeDto;
import org.example.main.entity.GameMode;
import org.example.main.mapper.GameModeDtoMapper;
import org.example.main.repository.GameModeRepository;
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
public class GameModeServiceTest {

    @InjectMocks
    private GameModeService gameModeService;
    @Mock
    private GameModeRepository gameModeRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest(){

        GameMode gameMode = GameMode.builder()
                .id(1L)
                .matches(new ArrayList<>())
                .numberOfPLayers((short) 4)
                .isEvent(true)
                .description("qwe")
                .name("qweq")
                .build();
        GameMode gameMode1 = GameMode.builder()
                .id(2L)
                .matches(new ArrayList<>())
                .numberOfPLayers((short) 4)
                .isEvent(true)
                .description("qwe")
                .name("zxc")
                .build();


        Mockito.when(gameModeRepository.findAll()).thenReturn(List.of(gameMode1,gameMode));

        List<GameModeDto> actualDtos = gameModeService.findAll();

        Mockito.verify(gameModeRepository, Mockito.times(1)).findAll();
        Assertions.assertFalse(actualDtos.isEmpty());
        Assertions.assertNotNull(actualDtos);
        Assertions.assertEquals(2, actualDtos.size());
    }

    @Test
    public void findByIdTest(){
        GameMode gameMode = GameMode.builder()
                .id(1L)
                .matches(new ArrayList<>())
                .numberOfPLayers((short) 4)
                .isEvent(true)
                .description("qwe")
                .name("qweq")
                .build();

        Mockito.when(gameModeRepository.findById(gameMode.getId())).thenReturn(gameMode);

        GameModeDto expected = GameModeDtoMapper.convertEntityToDto(gameMode);
        GameModeDto actual = gameModeService.findById(gameMode.getId());

        Mockito.verify(gameModeRepository, Mockito.times(1)).findById(Mockito.any());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void saveTest(){
        GameModeCreationDto gameModeDto = GameModeCreationDto.builder()
                .numberOfPLayers((short) 4)
                .isEvent(true)
                .description("qwe")
                .name("qweq")
                .build();

        GameMode gameMode = GameModeDtoMapper.buildEntity(gameModeDto);

        Mockito.when(gameModeRepository.create(Mockito.any(GameMode.class))).thenReturn(gameMode);

        gameModeService.addGameMode(gameModeDto);

        Mockito.verify(gameModeRepository, Mockito.times(1)).create(Mockito.any(GameMode.class));
    }

    @Test
    public void updateTest() {
        GameMode gameMode = GameMode.builder()
                .numberOfPLayers((short) 4)
                .isEvent(true)
                .description("qwe")
                .name("qweq")
                .build();

        GameModeDto dto = new GameModeDto();
        dto.setName("mlmzcx");
        dto.setMatches(new ArrayList<>());

        Mockito.when(gameModeRepository.findById(gameMode.getId())).thenReturn(gameMode);

        gameModeService.update(gameMode.getId(), dto);

        Mockito.verify(gameModeRepository, Mockito.times(1)).update(Mockito.any(GameMode.class));
    }
}
