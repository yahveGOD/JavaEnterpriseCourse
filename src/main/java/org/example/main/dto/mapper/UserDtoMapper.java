package org.example.main.dto.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.UserDto;
import org.example.main.entity.User;

@UtilityClass
public class UserDtoMapper {
    public static UserDto convertEntityToDto(User source)
    {
        return UserDto.builder()
                .uuid(source.getId())
                .name(source.getName())
                .averageMatchmakingRating(source.getAverageMatchmakingRating())
                .description(source.getDescription())
                .password(source.getPassword())
                .steamApiKey(source.getSteamApiKey())
                .build();
    }

    public static User convertDtoToEntity(UserDto source)
    {
        return User.builder()
                .id(source.getUuid())
                .name(source.getName())
                .averageMatchmakingRating(source.getAverageMatchmakingRating())
                .description(source.getDescription())
                .password(source.getPassword())
                .steamApiKey(source.getSteamApiKey())
                .build();
    }
}
