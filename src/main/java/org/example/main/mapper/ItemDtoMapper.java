package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.creationDto.ItemCreationDto;
import org.example.main.dto.ItemDto;
import org.example.main.entity.Item;

@UtilityClass
public class ItemDtoMapper {
    public static ItemDto convertEntityToDto(Item source)
    {
        return ItemDto.builder()
                .id(source.getId())
                .abilityDescription(source.getAbilityDescription())
                .boughtTimes(source.getBoughtTimes())
                .description(source.getDescription())
                .name(source.getName())
                .useRate(source.getUseRate())
                .winRate(source.getWinRate())
                .inventoryList(source.getInventoryList().stream().map(InventoryDtoMapper::convertEntityToDto).toList())
                .build();
    }

    public static Item convertDtoToEntity(ItemDto source)
    {
        return Item.builder()
                .abilityDescription(source.getAbilityDescription())
                .boughtTimes(source.getBoughtTimes())
                .description(source.getDescription())
                .name(source.getName())
                .useRate(source.getUseRate())
                .winRate(source.getWinRate())
                .inventoryList(source.getInventoryList().stream().map(InventoryDtoMapper::convertDtoToEntity).toList())
                .build();
    }

    public static Item buildEntity(ItemCreationDto source){
        return Item.builder()
                .abilityDescription(source.getDescription())
                .boughtTimes(source.getBoughtTimes())
                .name(source.getName())
                .abilityDescription(source.getAbilityDescription())
                .winRate(source.getWinRate())
                .useRate(source.getUseRate())
                .build();
    }
}
