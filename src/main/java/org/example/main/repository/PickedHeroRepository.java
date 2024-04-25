package org.example.main.repository;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.main.entity.*;
import org.example.main.exception.PickedHeroNotFoundException;
import org.example.main.repository.AbstractHibernateRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PickedHeroRepository extends AbstractHibernateRepository<PickedHero>{
    public PickedHeroRepository()
    {
        super(PickedHero.class);
    }
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    public PickedHero findByPickedHeroId(PickedHeroId pickedHeroId) {
        {
            List<PickedHero> pickedHeroList = new ArrayList<>();
            return pickedHeroList.stream()
                    .filter(x -> x.getPickedHeroId() == pickedHeroId)
                    .findFirst()
                    .orElseThrow(PickedHeroNotFoundException::new);
        }
    }
}
