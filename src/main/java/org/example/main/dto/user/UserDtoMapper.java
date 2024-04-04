package org.example.main.dto.user;

import lombok.experimental.UtilityClass;
import org.example.main.dto.user.UserDto;
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
                .name(source.getName())
                .averageMatchmakingRating(source.getAverageMatchmakingRating())
                .description(source.getDescription())
                .password(source.getPassword())
                .steamApiKey(source.getSteamApiKey())
                .build();
    }
}
