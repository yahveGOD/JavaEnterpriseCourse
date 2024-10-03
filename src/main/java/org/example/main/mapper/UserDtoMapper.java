package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.PickedHeroDto;
import org.example.main.dto.UserDto;
import org.example.main.dto.creationDto.TalentTreeCreationDto;
import org.example.main.dto.creationDto.UserCreationDto;
import org.example.main.entity.PickedHero;
import org.example.main.entity.TalentTree;
import org.example.main.entity.User;

@UtilityClass
public class UserDtoMapper {
    public static UserDto convertEntityToDto(User source)
    {
        return UserDto.builder()
                .id(source.getId())
                .name(source.getName())
                .averageMatchmakingRating(source.getAverageMatchmakingRating())
                .description(source.getDescription())
                .password(source.getPassword())
                .steamApiKey(source.getSteamApiKey())
                .roles(source.getRoles().stream()
                        .map(RoleDtoMapper::convertEntityToDto)
                        .toList())
                .matches(source.getMatches().stream()
                        .map(MatchDtoMapper::convertEntityToDto)
                        .toList())
                .pickedHeroes(source.getPickedHeroes().stream()
                        .map(pickedHero -> PickedHeroDto.builder()
                                .pickedHeroId(pickedHero.getPickedHeroId())
                                .build())
                        .toList())
                .build();
    }

    public static User convertDtoToEntity(UserDto source)
    {
        return User.builder()
                .name(source.getName())
                .averageMatchmakingRating(source.getAverageMatchmakingRating())
                .description(source.getDescription())
                .password(source.getPassword())
                .steamApiKey(source.getSteamApiKey())
                .roles(source.getRoles().stream().map(RoleDtoMapper::convertDtoToEntity).toList())
                .matches(source.getMatches().stream().map(MatchDtoMapper::convertDtoToEntity).toList())
                .pickedHeroes(source.getPickedHeroes().stream()
                        .map(pickedHeroDto -> PickedHero.builder()
                                .pickedHeroId(pickedHeroDto.getPickedHeroId())
                                .build())
                        .toList())
                .build();
    }

    public static User buildEntity(UserCreationDto source){
        return User.builder()
                .description(source.getDescription())
                .name(source.getName())
                .password(source.getPassword())
                .steamApiKey(source.getSteamApiKey())
                .build();
    }
}
