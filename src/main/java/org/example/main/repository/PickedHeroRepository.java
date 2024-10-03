package org.example.main.repository;

import jakarta.persistence.*;
import org.example.main.entity.*;
import org.example.main.controller.exception.PickedHeroNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PickedHeroRepository extends AbstractHibernateRepository<PickedHero>{
    public PickedHeroRepository()
    {
        super(PickedHero.class);
    }



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
