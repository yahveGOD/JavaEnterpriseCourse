package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.UserDto;
import org.example.main.dto.creationDto.RoleCreationDto;
import org.example.main.dto.RoleDto;
import org.example.main.entity.Role;
import org.example.main.entity.User;

import java.util.stream.Collectors;

@UtilityClass
public class RoleDtoMapper {
    public static RoleDto convertEntityToDto(Role source)
    {
        return RoleDto.builder()
                .title(source.getTitle())
                .id(source.getId())
                .users(source.getUsers().stream()
                        .map(user -> UserDto.builder()
                                .name(user.getName())
                                .id(user.getId())
                                .build())
                        .toList())
                .build();
    }

    public static Role convertDtoToEntity(RoleDto source)
    {
        return Role.builder()
                .title(source.getTitle())
                .users(source.getUsers().stream()
                        .map(userDto -> User.builder()
                                .name(userDto.getName())
                                .id(userDto.getId())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public static Role buildEntity(RoleCreationDto source){
        return Role.builder().title(source.getTitle()).build();
    }
}
