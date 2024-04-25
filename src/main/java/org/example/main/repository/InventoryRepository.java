package org.example.main.repository;

import org.example.main.entity.Inventory;
import org.example.main.repository.AbstractHibernateRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class InventoryRepository extends AbstractHibernateRepository<Inventory> {

    public InventoryRepository()
    {
        super(Inventory.class);
    }
}
