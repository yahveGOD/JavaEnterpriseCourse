package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.UserDto;
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
                .roles(source.getRoles().stream().map(RoleDtoMapper::convertEntityToDto).toList())
                .matches(source.getMatches().stream().map(MatchDtoMapper::convertEntityToDto).toList())
                .pickedHeroes(source.getPickedHeroes().stream().map(PickedHeroDtoMapper::convertEntityToDto).toList())
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
                .pickedHeroes(source.getPickedHeroes().stream().map(PickedHeroDtoMapper::convertDtoToEntity).toList())
                .build();
    }
}
