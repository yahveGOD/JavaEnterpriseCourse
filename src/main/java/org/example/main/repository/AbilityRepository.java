package org.example.main.repository;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.example.main.entity.Ability;
import org.example.main.entity.Ability_;
import org.example.main.repository.AbstractHibernateRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class AbilityRepository extends AbstractHibernateRepository<Ability>{
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;
    public AbilityRepository()
    {
        super(Ability.class);
    }

    public List<Ability> findAbilitiesByName(String name) {
        Query query = entityManager.createQuery("SELECT a FROM Ability a WHERE a.name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Ability> findAbilitiesByDamageType(String damageType) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ability> query = cb.createQuery(Ability.class);
        Root<Ability> root = query.from(Ability.class);
        query.select(root).where(cb.equal(root.get(Ability_.damageType), damageType));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Ability> fetchAbilitiesWithLazyAssociationsCriteriaApi()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ability> query = cb.createQuery(Ability.class);
        Root<Ability> root = query.from(Ability.class);
        root.fetch(Ability_.HERO);
        return entityManager.createQuery(query).getResultList();
    }

    public List<Ability> fetchAbilitiesWithLazyAssociationsJPQL() {
        String jpql = "SELECT a FROM Ability a LEFT JOIN FETCH a.hero";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    public List<Ability> fetchAbilitiesWithLazyAssociationsEntityGraph() {
        EntityGraph<Ability> entityGraph = entityManager.createEntityGraph(Ability.class);
        entityGraph.addSubgraph(Ability_.HERO);
        TypedQuery<Ability> query = entityManager.createQuery("SELECT a FROM Ability a", Ability.class);
        query.setHint("javax.persistence.fetchgraph", entityGraph);
        return query.getResultList();
    }

}

