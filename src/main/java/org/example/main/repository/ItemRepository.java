package org.example.main.repository;

import lombok.Getter;
import org.example.main.entity.Inventory;
import org.example.main.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ItemRepository {
    @Getter
    private List<Item> items;

    public ItemRepository() {
        items = new ArrayList<>();
        Item item1 = new Item(0,"ll",0.3F,0.1F,1000,"zxcqwe","abcde");
        Item item2 = new Item(1,"zz",0.3F,0.1F,1000,"zxcq123","abqweqweq");
        items.add(item1);
        items.add(item2);
    }
}
