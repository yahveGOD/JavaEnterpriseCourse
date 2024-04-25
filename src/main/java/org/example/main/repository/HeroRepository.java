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
public class HeroRepository extends AbstractHibernateRepository<Hero>{

    public HeroRepository()
    {
        super(Hero.class);
    }
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    public List<Hero> findHeroesByName(String name) {
        Query query = entityManager.createQuery("SELECT h FROM Hero h WHERE h.name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Hero> findHeroesByWinRate(float winRate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hero> query = cb.createQuery(Hero.class);
        Root<Hero> root = query.from(Hero.class);
        query.select(root).where(cb.equal(root.get(Hero_.WIN_RATE), winRate));
        return entityManager.createQuery(query).getResultList();
    }

}
