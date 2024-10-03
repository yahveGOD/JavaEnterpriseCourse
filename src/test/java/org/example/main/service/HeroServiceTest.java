package org.example.main.service;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.dto.creationDto.HeroCreationDto;
import org.example.main.dto.HeroDto;
import org.example.main.entity.Hero;
import org.example.main.mapper.HeroDtoMapper;
import org.example.main.repository.HeroRepository;
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
public class HeroServiceTest {
    @InjectMocks
    private HeroService heroService;
    @Mock
    private HeroRepository heroRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest(){

        Hero hero = Hero.builder()
                .id(1L)
                .agility(11)
                .intelligence(11)
                .name("zxc")
                .pickedHeroes(new ArrayList<>())
                .abilities(new ArrayList<>())
                .pickedTimes(1)
                .pickRate(0.1f)
                .strength(1)
                .winRate(0.4f)
                .build();
        Hero hero1 = Hero.builder()
                .id(2L)
                .agility(12)
                .intelligence(12)
                .pickedHeroes(new ArrayList<>())
                .abilities(new ArrayList<>())
                .name("qwe")
                .pickedTimes(1)
                .pickRate(0.1f)
                .strength(1)
                .winRate(0.4f)
                .build();

        Mockito.when(heroRepository.findAll()).thenReturn(List.of(hero,hero1));

        List<HeroDto> actualDtos = heroService.findAll();

        Mockito.verify(heroRepository, Mockito.times(1)).findAll();
        Assertions.assertFalse(actualDtos.isEmpty());
        Assertions.assertNotNull(actualDtos);
        Assertions.assertEquals(2, actualDtos.size());
    }

    @Test
    public void findByIdTest(){
        Hero hero = Hero.builder()
                .id(1L)
                .agility(11)
                .intelligence(11)
                .name("zxc")
                .pickedHeroes(new ArrayList<>())
                .abilities(new ArrayList<>())
                .pickedTimes(1)
                .pickRate(0.1f)
                .strength(1)
                .winRate(0.4f)
                .build();

        Mockito.when(heroRepository.findById(hero.getId())).thenReturn(hero);

        HeroDto expected = HeroDtoMapper.convertEntityToDto(hero);
        HeroDto actual = heroService.findById(hero.getId());

        Mockito.verify(heroRepository, Mockito.times(1)).findById(Mockito.any());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void saveTest(){
        HeroCreationDto heroDto = HeroCreationDto.builder()
                .agility(11)
                .intelligence(11)
                .name("zxc")
                .pickedTimes(1)
                .pickRate(0.1f)
                .strength(1)
                .winRate(0.4f)
                .build();

        Hero hero = HeroDtoMapper.buildEntity(heroDto);

        Mockito.when(heroRepository.create(Mockito.any(Hero.class))).thenReturn(hero);

        heroService.addHero(heroDto);

        Mockito.verify(heroRepository, Mockito.times(1)).create(Mockito.any(Hero.class));
    }

    @Test
    public void updateTest() {
        Hero hero = Hero.builder()
                .agility(11)
                .intelligence(11)
                .name("zxc")
                .pickedTimes(1)
                .pickRate(0.1f)
                .strength(1)
                .winRate(0.4f)
                .build();

        HeroDto dto = new HeroDto();
        dto.setName("mlmzcx");
        dto.setPickedHeroes(new ArrayList<>());
        dto.setAbilities(new ArrayList<>());

        Mockito.when(heroRepository.findById(hero.getId())).thenReturn(hero);

        heroService.update(hero.getId(), dto);

        Mockito.verify(heroRepository, Mockito.times(1)).update(Mockito.any(Hero.class));
    }


}
