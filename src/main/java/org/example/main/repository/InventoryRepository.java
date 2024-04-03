package org.example.main.repository;
import lombok.Getter;
import org.example.main.entity.Inventory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InventoryRepository {
    @Getter
    private List<Inventory> inventories;

    public InventoryRepository() {
        inventories = new ArrayList<>();
        Inventory inventory1 = new Inventory(0,0.5F);
        Inventory inventory2 = new Inventory(1,0.3F);
        inventories.add(inventory1);
        inventories.add(inventory2);
    }
}
