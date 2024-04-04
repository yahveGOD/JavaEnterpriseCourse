package org.example.main.repository;


import lombok.Getter;
import org.example.main.entity.Ability;
import org.example.main.entity.Hero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AbilityRepository extends AbstractRepository<Ability> {
    public AbilityRepository() {
        save(Ability.builder()
                .name("123")
                .hero(new Hero("123",0.5f,0.4f,100,10,10,10))
                .damageType("zxc")
                .description("qwe")
                .fixedDamage(123)
                .isPassive(true)
                .build());
        save(Ability.builder()
                .name("777")
                .hero(new Hero("zxc",0.5f,0.4f,11,11,11,11))
                .damageType("qwe")
                .description("xzc")
                .fixedDamage(777)
                .isPassive(true)
                .build());
    }
}

