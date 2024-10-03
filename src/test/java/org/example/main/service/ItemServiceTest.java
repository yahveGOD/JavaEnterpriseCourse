package org.example.main.service;

import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.dto.creationDto.ItemCreationDto;
import org.example.main.dto.ItemDto;
import org.example.main.entity.Item;
import org.example.main.mapper.ItemDtoMapper;
import org.example.main.repository.ItemRepository;
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
public class ItemServiceTest {
    @InjectMocks
    private ItemService itemService;
    @Mock
    private ItemRepository itemRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllTest(){

        Item item = Item.builder()
                .id(1L)
                .inventoryList(new ArrayList<>())
                .winRate(0.3f)
                .boughtTimes(11)
                .useRate(0.4f)
                .name("zxczxc")
                .description("qwe")
                .abilityDescription("zxcxzc")
                .build();

        Item item1 = Item.builder()
                .id(2L)
                .inventoryList(new ArrayList<>())
                .winRate(0.3f)
                .boughtTimes(1111111)
                .useRate(0.4f)
                .name("qwerty")
                .description("asd")
                .abilityDescription("zxcxzc")
                .build();
        Mockito.when(itemRepository.findAll()).thenReturn(List.of(item,item1));

        List<ItemDto> actualDtos = itemService.findAll();

        Mockito.verify(itemRepository, Mockito.times(1)).findAll();
        Assertions.assertFalse(actualDtos.isEmpty());
        Assertions.assertNotNull(actualDtos);
        Assertions.assertEquals(2, actualDtos.size());
    }

    @Test
    public void findByIdTest(){
        Item item = Item.builder()
                .id(1L)
                .inventoryList(new ArrayList<>())
                .winRate(0.3f)
                .boughtTimes(11)
                .useRate(0.4f)
                .name("zxczxc")
                .description("qwe")
                .abilityDescription("zxcxzc")
                .build();

        Mockito.when(itemRepository.findById(item.getId())).thenReturn(item);

        ItemDto expected = ItemDtoMapper.convertEntityToDto(item);
        ItemDto actual = itemService.findById(item.getId());

        Mockito.verify(itemRepository, Mockito.times(1)).findById(Mockito.any());
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void saveTest(){
        ItemCreationDto itemDto = ItemCreationDto.builder()
                .winRate(0.3f)
                .boughtTimes(11)
                .useRate(0.4f)
                .name("zxczxc")
                .description("qwe")
                .abilityDescription("zxcxzc")
                .build();

        Item item = ItemDtoMapper.buildEntity(itemDto);

        Mockito.when(itemRepository.create(Mockito.any(Item.class))).thenReturn(item);

        itemService.addItem(itemDto);

        Mockito.verify(itemRepository, Mockito.times(1)).create(Mockito.any(Item.class));
    }

    @Test
    public void updateTest() {
        Item item = Item.builder()
                .winRate(0.3f)
                .boughtTimes(11)
                .useRate(0.4f)
                .name("zxczxc")
                .description("qwe")
                .abilityDescription("zxcxzc")
                .build();

        ItemDto dto = new ItemDto();
        dto.setUseRate(0.3f);
        dto.setInventoryList(new ArrayList<>());

        Mockito.when(itemRepository.findById(item.getId())).thenReturn(item);

        itemService.update(item.getId(), dto);

        Mockito.verify(itemRepository, Mockito.times(1)).update(Mockito.any(Item.class));
    }
}
