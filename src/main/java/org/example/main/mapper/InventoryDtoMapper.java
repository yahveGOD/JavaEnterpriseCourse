package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.InventoryDto;
import org.example.main.entity.Inventory;

@UtilityClass
public class InventoryDtoMapper {
    public static InventoryDto convertEntityToDto(Inventory source)
    {
        return InventoryDto.builder()
                .id(source.getId())
                .buildEffectivity(source.getBuildEffectivity())
                .items(source.getItems().stream().map(ItemDtoMapper::convertEntityToDto).toList())
                .pickedHeroes(source.getPickedHeroes().stream().map(PickedHeroDtoMapper::convertEntityToDto).toList())
                .build();
    }

    public static Inventory convertDtoToEntity(InventoryDto source)
    {
        return Inventory.builder()
                .buildEffectivity(source.getBuildEffectivity())
                .items(source.getItems().stream().map(ItemDtoMapper::convertDtoToEntity).toList())
                .pickedHeroes(source.getPickedHeroes().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList())
                .build();
    }
}
