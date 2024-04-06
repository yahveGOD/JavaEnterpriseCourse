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
                .build();
    }

    public static Inventory convertDtoToEntity(InventoryDto source)
    {
        return Inventory.builder()
                .buildEffectivity(source.getBuildEffectivity())
                .build();
    }
}
