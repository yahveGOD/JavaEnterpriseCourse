package org.example.main.repository;
import lombok.Getter;
import org.example.main.entity.Inventory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InventoryRepository extends AbstractRepository<Inventory>{

    public InventoryRepository() {
        save(Inventory.builder()
                .buildEffectivity(0.5f)
                .build());
    }
}
