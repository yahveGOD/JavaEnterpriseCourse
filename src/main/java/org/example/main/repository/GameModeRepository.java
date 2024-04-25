package org.example.main.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.main.entity.GameMode;
import org.example.main.entity.GameMode_;
import org.example.main.repository.AbstractHibernateRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class GameModeRepository extends AbstractHibernateRepository<GameMode>{

    public GameModeRepository()
    {
        super(GameMode.class);
    }
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    public List<GameMode> findGameModesByName(String name)  {
        Query query = entityManager.createQuery("SELECT g FROM GameMode g WHERE g.name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<GameMode> findGameModesByNumberOfPLayers(int numberOfPlayers) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GameMode> query = cb.createQuery(GameMode.class);
        Root<GameMode> root = query.from(GameMode.class);
        query.select(root).where(cb.equal(root.get(GameMode_.NUMBER_OF_PLAYERS), numberOfPlayers));
        return entityManager.createQuery(query).getResultList();
    }


}
