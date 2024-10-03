package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.ItemDto;
import org.example.main.dto.PickedHeroDto;
import org.example.main.dto.creationDto.InventoryCreationDto;
import org.example.main.dto.InventoryDto;
import org.example.main.entity.Inventory;
import org.example.main.entity.Item;
import org.example.main.entity.PickedHero;

import java.util.stream.Collectors;

@UtilityClass
public class InventoryDtoMapper {
    public static InventoryDto convertEntityToDto(Inventory source)
    {
        return InventoryDto.builder()
                .id(source.getId())
                .buildEffectivity(source.getBuildEffectivity())
                .items(source.getItems().stream()
                        .map(item -> ItemDto.builder()
                                .name(item.getName())
                                .id(item.getId())
                                .build())
                        .toList())
                .pickedHeroes(source.getPickedHeroes().stream()
                        .map(pickedHero -> PickedHeroDto.builder()
                                .pickedHeroId(pickedHero.getPickedHeroId())
                                .build())
                        .toList())
                .build();
    }

    public static Inventory convertDtoToEntity(InventoryDto source)
    {
        return Inventory.builder()
                .buildEffectivity(source.getBuildEffectivity())
                .items(source.getItems().stream()
                        .map(itemDto -> Item.builder()
                                .name(itemDto.getName())
                                .id(itemDto.getId())
                                .build())
                        .collect(Collectors.toList()))
                .pickedHeroes(source.getPickedHeroes().stream()
                        .map(pickedHeroDto -> PickedHero.builder()
                                .pickedHeroId(pickedHeroDto.getPickedHeroId())
                                .build())
                        .toList())
                .build();
    }

    public static Inventory buildEntity(InventoryCreationDto source){
        return Inventory.builder()
                .buildEffectivity(source.getBuildEffectivity())
                .build();
    }
}
