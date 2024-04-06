package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.Inventory;
import org.example.main.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ItemRepository extends AbstractRepository<Item>{
    public ItemRepository() {
        save(Item.builder()
                .abilityDescription("zxc")
                .boughtTimes(123)
                .description("123")
                .name("uragan")
                .useRate(0.4f)
                .winRate(0.5f)
                .build());
        save(Item.builder()
                .abilityDescription("qwe")
                .boughtTimes(1)
                .description("qwe")
                .name("qwe")
                .useRate(1f)
                .winRate(1f)
                .build());
    }
}
