package org.example.main.mapper;

import lombok.experimental.UtilityClass;
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
                .build();
    }
}
