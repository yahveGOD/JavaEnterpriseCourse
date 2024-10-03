package org.example.main.service;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.dto.InventoryDto;
import org.example.main.dto.MatchDto;
import org.example.main.dto.PickedHeroDto;
import org.example.main.dto.creationDto.MatchCreationDto;
import org.example.main.dto.creationDto.PickedHeroCreationDto;
import org.example.main.entity.*;
import org.example.main.mapper.MatchDtoMapper;
import org.example.main.mapper.PickedHeroDtoMapper;
import org.example.main.repository.MatchRepository;
import org.example.main.repository.PickedHeroRepository;
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
public class PickedHeroServiceTest {
    @InjectMocks
    private PickedHeroService pickedHeroService;
    @Mock
    private PickedHeroRepository pickedHeroRepository;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest(){

        PickedHero pickedHero = PickedHero.builder()
                .user(User.builder()
                        .id(2L)
                        .name("zxc")
                        .build())
                .statistics(Statistics.builder()
                        .id(1L)
                        .kills(13)
                        .deaths(12)
                        .assists(11)
                        .build())
                .inventory(Inventory.builder()
                        .id(1L)
                        .build())
                .heroes(new ArrayList<Hero>())
                .matches(new ArrayList<Match>())
                .build();

        PickedHero pickedHero1 = PickedHero.builder()
                .user(User.builder()
                        .id(1L)
                        .name("zxc")
                        .build())
                .statistics(Statistics.builder()
                        .id(1L)
                        .kills(13)
                        .deaths(12)
                        .assists(11)
                        .build())
                .inventory(Inventory.builder()
                        .id(1L)
                        .build())
                .heroes(new ArrayList<Hero>())
                .matches(new ArrayList<Match>())
                .build();
        Mockito.when(pickedHeroRepository.findAll()).thenReturn(List.of(pickedHero1,pickedHero));

        List<PickedHeroDto> actualDtos = pickedHeroService.findAll();

        Mockito.verify(pickedHeroRepository, Mockito.times(1)).findAll();
        Assertions.assertFalse(actualDtos.isEmpty());
        Assertions.assertNotNull(actualDtos);
        Assertions.assertEquals(2, actualDtos.size());
    }

    @Test
    public void findByIdTest(){
        PickedHero pickedHero = PickedHero.builder()
                .pickedHeroId(new PickedHeroId(1L,1L))
                .user(User.builder()
                        .id(1L)
                        .name("zxc")
                        .build())
                .statistics(Statistics.builder()
                        .id(1L)
                        .kills(13)
                        .deaths(12)
                        .assists(11)
                        .build())
                .inventory(Inventory.builder()
                        .id(1L)
                        .build())
                .heroes(new ArrayList<Hero>())
                .matches(new ArrayList<Match>())
                .build();

        Mockito.when(pickedHeroRepository.findByPickedHeroId(pickedHero.getPickedHeroId())).thenReturn(pickedHero);

        PickedHeroDto expected = PickedHeroDtoMapper.convertEntityToDto(pickedHero);
        PickedHeroDto actual = pickedHeroService.findByPickedHeroId(pickedHero.getPickedHeroId());

        Mockito.verify(pickedHeroRepository, Mockito.times(1)).findByPickedHeroId(Mockito.any());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getInventory().getBuildEffectivity(), actual.getInventory().getBuildEffectivity());
    }

    @Test
    public void saveTest(){
        PickedHeroCreationDto pickedHeroDto = PickedHeroCreationDto.builder()
                .pickedHeroId(new PickedHeroId(1L,1L))
                .build();
        PickedHero pickedHero = PickedHeroDtoMapper.buildEntity(pickedHeroDto);

        Mockito.when(pickedHeroRepository.create(Mockito.any(PickedHero.class))).thenReturn(pickedHero);

        pickedHeroService.addPickedHero(pickedHeroDto);

        Mockito.verify(pickedHeroRepository, Mockito.times(1)).create(Mockito.any(PickedHero.class));
    }

    @Test
    public void updateTest() {
        PickedHero pickedHero = PickedHero.builder()
                .user(new User())
                .statistics(new Statistics())
                .inventory(Inventory.builder()
                        .buildEffectivity(0.4f)
                        .build())
                .heroes(new ArrayList<Hero>())
                .matches(new ArrayList<Match>())
                .build();
        PickedHeroDto dto = new PickedHeroDto();
        dto.setInventory(InventoryDto.builder()
                .buildEffectivity(0.2f)
                .build());

        Mockito.when(pickedHeroRepository.findByPickedHeroId(pickedHero.getPickedHeroId())).thenReturn(pickedHero);

        pickedHeroService.update(pickedHero.getPickedHeroId(), dto);

        Mockito.verify(pickedHeroRepository, Mockito.times(1)).update(Mockito.any(PickedHero.class));
    }
}
