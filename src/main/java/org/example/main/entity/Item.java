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
@Table(name = "item")
public class Item extends BaseEntity {
    @ManyToMany(mappedBy = "items",fetch = FetchType.LAZY)
    List<Inventory> inventoryList;
    @Column(name = "name")
    private String name;
    @Column(name = "win_rate")
    private Float winRate;
    @Column(name = "use_rate")
    private Float useRate;
    @Column(name = "bought_times")
    private Integer boughtTimes;
    @Column(name = "description")
    private String description;
    @Column(name = "ability_description")
    private String abilityDescription;
}
