package org.example.main.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.main.entity.BaseEntity;
import org.example.main.entity.User;
import org.example.main.exception.IdNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public abstract class AbstractHibernateRepository <T>{
    private Class<T> clazz;
    public AbstractHibernateRepository(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;
    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(Long entityId) {
        final T entity = findById(entityId);
        delete(entity);
    }
    public T findById(final long id) {
        return entityManager.find(clazz, id);
    }
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }
}
