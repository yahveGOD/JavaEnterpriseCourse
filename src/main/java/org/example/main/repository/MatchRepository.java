package org.example.main.repository;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.example.main.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MatchRepository extends AbstractHibernateRepository<Match>{

    public MatchRepository()
    {
        super(Match.class);
    }
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    public List<Match> findMatchesByRadiantKills(Long radiantKills) {
        Query query = entityManager.createQuery("SELECT m FROM Match m WHERE m.radiantKills = :radiantKills");
        query.setParameter("radiantKills", radiantKills);
        return query.getResultList();
    }

    public List<Match> fetchMatchesWithLazyAssociationsCriteriaApi()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Match> query = cb.createQuery(Match.class);
        Root<Match> root = query.from(Match.class);
        root.fetch(Match_.GAME_MODE, JoinType.LEFT);
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Match> fetchMatchesWithLazyAssociationsJPQL() {
        String jpql = "SELECT m FROM Match m LEFT JOIN FETCH m.gameMode";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    public List<Match> fetchMatchesWithLazyAssociationsEntityGraph() {
        EntityGraph<Match> entityGraph = entityManager.createEntityGraph(Match.class);
        entityGraph.addSubgraph(Match_.GAME_MODE);
        TypedQuery<Match> query = entityManager.createQuery("SELECT m FROM Match m", Match.class);
        query.setHint("javax.persistence.fetchgraph", entityGraph);
        return query.getResultList();
    }

}
