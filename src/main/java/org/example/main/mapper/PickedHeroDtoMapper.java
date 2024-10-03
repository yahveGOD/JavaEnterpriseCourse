package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.*;
import org.example.main.dto.creationDto.MatchCreationDto;
import org.example.main.dto.creationDto.PickedHeroCreationDto;
import org.example.main.entity.*;

import java.util.stream.Collectors;

@UtilityClass
public class PickedHeroDtoMapper {
    public static PickedHeroDto convertEntityToDto(PickedHero source)
    {
        return PickedHeroDto.builder()
                .heroes(source.getHeroes().stream()
                        .map(hero -> HeroDto.builder()
                                .id(hero.getId())
                                .build())
                        .toList())
                .matches(source.getMatches().stream()
                        .map(match -> MatchDto.builder()
                                .id(match.getId())
                                .victorySide(match.getVictorySide())
                                .build())
                        .toList())
                .user(UserDto.builder()
                        .id(source.getUser().getId())
                        .name(source.getUser().getName())
                        .build())
                .statistics(StatisticsDto.builder()
                        .id(source.getStatistics().getId())
                        .kills(source.getStatistics().getKills())
                        .deaths(source.getStatistics().getDeaths())
                        .assists(source.getStatistics().getAssists())
                        .build())
                .inventory(InventoryDto.builder()
                        .id(source.getInventory().getId())
                        .build())
                .pickedHeroId(source.getPickedHeroId())
                .build();
    }

    public static PickedHero convertDtoToEntity(PickedHeroDto source)
    {
        return PickedHero.builder()
                .heroes(source.getHeroes().stream()
                        .map(heroDto -> Hero.builder()
                                .id(heroDto.getId())
                                .name(heroDto.getName())
                                .build())
                        .collect(Collectors.toList()))
                .matches(source.getMatches().stream()
                        .map(matchDto -> Match.builder()
                                .id(matchDto.getId())
                                .victorySide(matchDto.getVictorySide())
                                .build())
                        .collect(Collectors.toList()))
                .user(User.builder()
                        .name(source.getUser().getName())
                        .id(source.getUser().getId())
                        .build())
                .statistics(Statistics.builder()
                        .id(source.getStatistics().getId())
                        .build())
                .inventory(Inventory.builder()
                        .id(source.getInventory().getId())
                        .build())
                .pickedHeroId(source.getPickedHeroId())
                .build();
    }

    public static PickedHero buildEntity(PickedHeroCreationDto source){
        return PickedHero.builder()
                .pickedHeroId(source.getPickedHeroId())
                .build();
    }
}
