package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.PickedHeroDto;
import org.example.main.entity.PickedHero;

@UtilityClass
public class PickedHeroDtoMapper {
    public static PickedHeroDto convertEntityToDto(PickedHero source)
    {
        return PickedHeroDto.builder()
                .hero(HeroDtoMapper.convertEntityToDto(source.getHero()))
                .match(MatchDtoMapper.convertEntityToDto(source.getMatch()))
                .user(UserDtoMapper.convertEntityToDto(source.getUser()))
                .statistics(StatisticsDtoMapper.convertEntityToDto(source.getStatistics()))
                .inventory(InventoryDtoMapper.convertEntityToDto(source.getInventory()))
                .build();
    }

    public static PickedHero convertDtoToEntity(PickedHeroDto source)
    {
        return PickedHero.builder()
                .hero(HeroDtoMapper.convertDtoToEntity(source.getHero()))
                .match(MatchDtoMapper.convertDtoToEntity(source.getMatch()))
                .user(UserDtoMapper.convertDtoToEntity(source.getUser()))
                .statistics(StatisticsDtoMapper.convertDtoToEntity(source.getStatistics()))
                .inventory(InventoryDtoMapper.convertDtoToEntity(source.getInventory()))
                .build();
    }
}
