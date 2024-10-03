package org.example.main.service;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.dto.StatisticsDto;
import org.example.main.dto.TalentTreeDto;
import org.example.main.dto.creationDto.StatisticsCreationDto;
import org.example.main.dto.creationDto.TalentTreeCreationDto;
import org.example.main.entity.Hero;
import org.example.main.entity.Statistics;
import org.example.main.entity.TalentBranch;
import org.example.main.entity.TalentTree;
import org.example.main.mapper.StatisticsDtoMapper;
import org.example.main.mapper.TalentTreeDtoMapper;
import org.example.main.repository.StatisticsRepository;
import org.example.main.repository.TalentTreeRepository;
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

import java.util.List;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = { LiquibaseConfig.class, HibernateConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class TalentTreeServiceTest {
    @InjectMocks
    private TalentTreeService talentTreeService;
    @Mock
    private TalentTreeRepository talentTreeRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest(){

        TalentTree talentTree = TalentTree.builder()
                .id(1L)
                .hero(Hero.builder()
                        .id(1L)
                        .name("zxc")
                        .build())
                .levelRequired(5)
                //.talentBranch(new TalentBranch())
                .cells("zxc")
                .build();

        TalentTree talentTree1 = TalentTree.builder()
                .id(2L)
                .hero(Hero.builder()
                        .id(1L)
                        .name("zxc")
                        .build())
                .levelRequired(10)
                .cells("zxc")
                //.talentBranch(new TalentBranch())
                .build();
        Mockito.when(talentTreeRepository.findAll()).thenReturn(List.of(talentTree,talentTree1));

        List<TalentTreeDto> actualDtos = talentTreeService.findAll();

        Mockito.verify(talentTreeRepository, Mockito.times(1)).findAll();
        Assertions.assertFalse(actualDtos.isEmpty());
        Assertions.assertNotNull(actualDtos);
        Assertions.assertEquals(2, actualDtos.size());
    }

    @Test
    public void findByIdTest(){
        TalentTree talentTree = TalentTree.builder()
                .id(1L)
                .hero(Hero.builder()
                        .id(1L)
                        .name("zxc")
                        .build())
                .levelRequired(5)
                .cells("zxc")
                //.talentBranch(new TalentBranch())
                .build();

        Mockito.when(talentTreeRepository.findById(talentTree.getId())).thenReturn(talentTree);

        TalentTreeDto expected = TalentTreeDtoMapper.convertEntityToDto(talentTree);
        TalentTreeDto actual = talentTreeService.findById(talentTree.getId());

        Mockito.verify(talentTreeRepository, Mockito.times(1)).findById(Mockito.any());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getLevelRequired(), actual.getLevelRequired());
    }

    @Test
    public void saveTest(){
        TalentTreeCreationDto talentTreeDto = TalentTreeCreationDto.builder()
                .levelRequired(5)
                .talentBranch(new TalentBranch())
                .build();
        TalentTree talentTree = TalentTreeDtoMapper.buildEntity(talentTreeDto);

        Mockito.when(talentTreeRepository.create(Mockito.any(TalentTree.class))).thenReturn(talentTree);

        talentTreeService.addTalentTree(talentTreeDto);

        Mockito.verify(talentTreeRepository, Mockito.times(1)).create(Mockito.any(TalentTree.class));
    }

    @Test
    public void updateTest() {
        TalentTree talentTree = TalentTree.builder()
                .levelRequired(5)
                .cells("zxc")
                //.talentBranch(new TalentBranch())
                .build();
        TalentTreeDto dto = new TalentTreeDto();
        dto.setLevelRequired(1111);

        Mockito.when(talentTreeRepository.findById(talentTree.getId())).thenReturn(talentTree);

        talentTreeService.update(talentTree.getId(), dto);

        Mockito.verify(talentTreeRepository, Mockito.times(1)).update(Mockito.any(TalentTree.class));
    }
}
