package org.example.main.dto;

import lombok.*;
import org.example.main.entity.Inventory;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private long id;
    private String name;
    private float winRate;
    private float useRate;
    private int boughtTimes;
    private String description;
    private String abilityDescription;
    List<InventoryDto> inventoryList;

}
