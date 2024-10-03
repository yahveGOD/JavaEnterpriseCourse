package org.example.main.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public abstract class AbstractHibernateRepository <T>{
    protected final Class<T> clazz;
    @PersistenceContext
    protected EntityManager entityManager;
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
    public T findById(final Long id) {
        return entityManager.find(clazz, id);
    }
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("select t from " + clazz.getSimpleName()+" as t").getResultList();
    }
}
