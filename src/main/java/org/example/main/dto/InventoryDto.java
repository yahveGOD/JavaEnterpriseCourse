package org.example.main.dto;

import lombok.*;
import org.example.main.entity.Item;
import org.example.main.entity.PickedHero;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {
    private long id;
    private float buildEffectivity;
    private List<ItemDto> items;
    private List<PickedHeroDto> pickedHeroes;
}
