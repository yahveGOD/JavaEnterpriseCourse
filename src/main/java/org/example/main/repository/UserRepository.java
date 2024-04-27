package org.example.main.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.main.entity.*;
import org.example.main.repository.AbstractHibernateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepository extends AbstractHibernateRepository<User>{
    public UserRepository()
    {
        super(User.class);
    }
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    public List<User> findUsersByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(cb.equal(root.get(User_.NAME), name));
        return entityManager.createQuery(query).getResultList();
    }

}

