package org.example.main.dto.inventory;

import lombok.experimental.UtilityClass;
import org.example.main.dto.inventory.InventoryDto;
import org.example.main.entity.Inventory;

@UtilityClass
public class InventoryDtoMapper {
    public static InventoryDto convertEntityToDto(Inventory source)
    {
        return InventoryDto.builder()
                .uuid(source.getId())
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
