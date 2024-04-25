package org.example.main.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.main.entity.*;
import org.example.main.repository.AbstractHibernateRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class ItemRepository extends AbstractHibernateRepository<Item>{


    public ItemRepository()
    {
        super(Item.class);
    }
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;
    public List<Item> findItemsByName(String name) {
        Query query = entityManager.createQuery("SELECT i FROM Item i WHERE i.name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Item> findItemsByWinRate(float winRate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Item> query = cb.createQuery(Item.class);
        Root<Item> root = query.from(Item.class);
        query.select(root).where(cb.equal(root.get(Item_.WIN_RATE), winRate));
        return entityManager.createQuery(query).getResultList();
    }

}
