package org.example.main.service;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.dto.creationDto.InventoryCreationDto;
import org.example.main.dto.InventoryDto;
import org.example.main.entity.Inventory;
import org.example.main.mapper.InventoryDtoMapper;
import org.example.main.repository.InventoryRepository;
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
public class InventoryServiceTest {
    @InjectMocks
    private InventoryService inventoryService;
    @Mock
    private InventoryRepository inventoryRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest(){

        Inventory inventory = Inventory.builder()
                .id(1L)
                .buildEffectivity(0.4f)
                .items(new ArrayList<>())
                .pickedHeroes(new ArrayList<>())
                .build();

        Inventory inventory1 = Inventory.builder()
                .buildEffectivity(0.5f)
                .id(2L)
                .items(new ArrayList<>())
                .pickedHeroes(new ArrayList<>())
                .build();
        Mockito.when(inventoryRepository.findAll()).thenReturn(List.of(inventory1,inventory));

        List<InventoryDto> actualDtos = inventoryService.findAll();

        Mockito.verify(inventoryRepository, Mockito.times(1)).findAll();
        Assertions.assertFalse(actualDtos.isEmpty());
        Assertions.assertNotNull(actualDtos);
        Assertions.assertEquals(2, actualDtos.size());
    }

    @Test
    public void findByIdTest(){
        Inventory inventory = Inventory.builder()
                .id(1L)
                .items(new ArrayList<>())
                .pickedHeroes(new ArrayList<>())
                .buildEffectivity(0.4f)
                .items(new ArrayList<>())
                .pickedHeroes(new ArrayList<>())
                .build();

        Mockito.when(inventoryRepository.findById(inventory.getId())).thenReturn(inventory);

        InventoryDto expected = InventoryDtoMapper.convertEntityToDto(inventory);
        InventoryDto actual = inventoryService.findById(inventory.getId());

        Mockito.verify(inventoryRepository, Mockito.times(1)).findById(Mockito.any());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getBuildEffectivity(), actual.getBuildEffectivity());
    }

    @Test
    public void saveTest(){
        InventoryCreationDto inventoryDto = InventoryCreationDto.builder()
                .buildEffectivity(0.4f)
                .build();

        Inventory inventory = InventoryDtoMapper.buildEntity(inventoryDto);

        Mockito.when(inventoryRepository.create(Mockito.any(Inventory.class))).thenReturn(inventory);

        inventoryService.addInventory(inventoryDto);

        Mockito.verify(inventoryRepository, Mockito.times(1)).create(Mockito.any(Inventory.class));
    }

    @Test
    public void updateTest() {
        Inventory inventory = Inventory.builder()
                .buildEffectivity(0.4f)
                .build();

        InventoryDto dto = new InventoryDto();
        dto.setBuildEffectivity(0.3f);
        dto.setItems(new ArrayList<>());
        dto.setPickedHeroes(new ArrayList<>());
        Mockito.when(inventoryRepository.findById(inventory.getId())).thenReturn(inventory);

        inventoryService.update(inventory.getId(), dto);

        Mockito.verify(inventoryRepository, Mockito.times(1)).update(Mockito.any(Inventory.class));
    }
}
