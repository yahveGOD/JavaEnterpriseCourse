package org.example.main.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.main.entity.TalentTree;
import org.example.main.repository.AbstractHibernateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TalentTreeRepository extends AbstractHibernateRepository<TalentTree> {


    public TalentTreeRepository()
    {
        super(TalentTree.class);
    }
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    public List<TalentTree> fetchTalentTreesWithLazyAssociationsJPQL() {
        String jpql = "SELECT tt FROM talant_tree tt LEFT JOIN FETCH tt.hero";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }
}
