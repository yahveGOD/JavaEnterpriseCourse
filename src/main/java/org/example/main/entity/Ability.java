package org.example.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ability")
public class Ability extends BaseEntity {
    @JoinColumn(name = "hero_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Hero hero;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "damage_type")
    private String damageType;

    @Column(name = "fixed_damage")
    private Integer fixedDamage;

    @Column(name = "is_passive")
    private Boolean isPassive;
}
