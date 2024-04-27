package org.example.main.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.main.entity.Replay;
import org.example.main.repository.AbstractHibernateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReplayRepository extends AbstractHibernateRepository<Replay> {

    public ReplayRepository()
    {
        super(Replay.class);
    }
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;
    public List<Replay> findReplaysBySteamApi(Long steamApiKey) {
        Query query = entityManager.createQuery("SELECT r FROM Replay r WHERE r.steamApiMatchReplayKey = :steam_api");
        query.setParameter("steam_api", steamApiKey);
        return query.getResultList();
    }

    public List<Replay> fetchReplaysWithLazyAssociationsJPQL() {
        String jpql = "SELECT r FROM Replay r LEFT JOIN FETCH r.match";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }
}
