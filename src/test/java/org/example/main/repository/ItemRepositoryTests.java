package org.example.main.repository;


import org.example.main.configuration.HibernateConfig;
import org.example.main.configuration.LiquibaseConfig;
import org.example.main.entity.Hero;
import org.example.main.entity.Item;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = {HibernateConfig.class, LiquibaseConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class ItemRepositoryTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void givenItem_whenFindByName_thenOk() {
        Item item = Item.builder()
                .useRate(0.4f)
                .winRate(0.3f)
                .name("zxc")
                .description("qwe")
                .boughtTimes(1111)
                .abilityDescription("qwe")
                .build();

        Item item1 = Item.builder()
                .useRate(0.4f)
                .winRate(0.3f)
                .name("zxcqwe")
                .description("qwe")
                .boughtTimes(1111)
                .abilityDescription("qwe")
                .build();

        itemRepository.create(item1);
        itemRepository.create(item);
        List<Item> testItem = itemRepository.findItemsByName(item1.getName());

        Assertions.assertEquals(1, testItem.size());
        Assertions.assertEquals(testItem.stream().allMatch(t -> t.getName().equals(item1.getName())), true);
    }

    @Test
    public void givenHero_whenFindByWinRate_thenOk() {
        Item item = Item.builder()
                .useRate(0.4f)
                .winRate(0.3f)
                .name("zxc")
                .description("qwe")
                .boughtTimes(1111)
                .abilityDescription("qwe")
                .build();

        Item item1 = Item.builder()
                .useRate(0.4f)
                .winRate(0.3f)
                .name("zxcqwe")
                .description("qwe")
                .boughtTimes(1111)
                .abilityDescription("qwe")
                .build();

        itemRepository.create(item1);
        itemRepository.create(item);
        List<Item> testItem = itemRepository.findItemsByWinRate(item1.getWinRate());

        Assertions.assertEquals(2, testItem.size());
        Assertions.assertEquals(testItem.stream().allMatch(t -> t.getWinRate().equals(item1.getWinRate())), true);
    }
}
