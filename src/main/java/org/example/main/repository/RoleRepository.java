package org.example.main.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.main.entity.Role;
import org.example.main.repository.AbstractHibernateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository extends AbstractHibernateRepository<Role> {

    public RoleRepository()
    {
        super(Role.class);
    }
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    public List<Role> findRolesByTitle(String title) {
        Query query = entityManager.createQuery("SELECT r FROM Role r WHERE r.title = :title");
        query.setParameter("title", title);
        return query.getResultList();
    }
}
