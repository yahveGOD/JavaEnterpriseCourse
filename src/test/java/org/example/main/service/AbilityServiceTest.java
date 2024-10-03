package org.example.main.service;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.dto.HeroDto;
import org.example.main.dto.creationDto.AbilityCreationDto;
import org.example.main.dto.AbilityDto;
import org.example.main.entity.Ability;
import org.example.main.entity.Hero;
import org.example.main.entity.PickedHero;
import org.example.main.mapper.AbilityDtoMapper;
import org.example.main.repository.AbilityRepository;
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
        classes = { LiquibaseConfig.class,HibernateConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class AbilityServiceTest {
    @InjectMocks
    private AbilityService abilityService;
    @Mock
    private AbilityRepository abilityRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest(){

        Ability ability = Ability.builder()
                .id(1L)
                .description("asd")
                .hero(Hero.builder()
                        .id(1L)
                        .name("asd")
                        .build())
                .name("zxc")
                .fixedDamage(123)
                .damageType("qwe")
                .build();
        Ability ability1 = Ability.builder()
                .id(2L)
                .hero(Hero.builder()
                        .id(2L)
                        .name("zxc")
                        .build())
                .name("qwe")
                .fixedDamage(123)
                .damageType("qwe")
                .build();

        Mockito.when(abilityRepository.findAll())
                .thenReturn(List.of(ability,ability1));

        List<AbilityDto> actualDtos = abilityService.findAll();

        Mockito.verify(abilityRepository, Mockito.times(1)).findAll();
        Assertions.assertFalse(actualDtos.isEmpty());
        Assertions.assertNotNull(actualDtos);
        Assertions.assertEquals(2, actualDtos.size());
    }

    @Test
    public void findByIdTest(){
        Ability ability = Ability.builder()
                .name("zxc")
                .fixedDamage(123)
                .hero(Hero.builder()
                        .id(1L)
                        .name("zxc")
                        .build())
                .damageType("qwe")
                .build();

        Mockito.when(abilityRepository.findById(ability.getId())).thenReturn(ability);

        AbilityDto expected = AbilityDtoMapper.convertEntityToDto(ability);
        AbilityDto actual = abilityService.findById(ability.getId());

        Mockito.verify(abilityRepository, Mockito.times(1)).findById(Mockito.any());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void saveTest(){
        AbilityCreationDto abilityDto = AbilityCreationDto.builder()
                .name("zxc")
                .fixedDamage(123)
                .damageType("qwe")
                .description("zxczxc")
                .isPassive(true)
                .build();

        Ability ability = AbilityDtoMapper.buildEntity(abilityDto);

        Mockito.when(abilityRepository.create(Mockito.any(Ability.class))).thenReturn(ability);

        abilityService.addAbility(abilityDto);

        Mockito.verify(abilityRepository, Mockito.times(1)).create(Mockito.any(Ability.class));
    }

    @Test
    public void updateTest() {
        Ability ability = Ability.builder()
                .id(1L)
                .name("zxc")
                .fixedDamage(123)
                .damageType("qwe")
                .build();

        AbilityDto dto = new AbilityDto();
        dto.setName("mlmzcx");
        dto.setFixedDamage(1231);
        dto.setHero(HeroDto.builder()
                        .abilities(new ArrayList<>(){})
                        .pickedHeroes(new ArrayList<>())
                .build());
        Mockito.when(abilityRepository.findById(ability.getId())).thenReturn(ability);

        abilityService.update(ability.getId(), dto);

        Mockito.verify(abilityRepository, Mockito.times(1)).update(Mockito.any(Ability.class));
    }

}
