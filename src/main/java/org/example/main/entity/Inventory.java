package org.example.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory")
public class Inventory extends BaseEntity {
    @JoinTable(
            name = "inventory_items",
            joinColumns = { @JoinColumn(name = "inventory_id") },
            inverseJoinColumns = { @JoinColumn(name = "item_id") }
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Item> items;

    @Column(name = "build_effectivity")
    private Float buildEffectivity;

    @OneToMany(mappedBy = "inventory",fetch = FetchType.LAZY)
    private List<PickedHero> pickedHeroes;
}
