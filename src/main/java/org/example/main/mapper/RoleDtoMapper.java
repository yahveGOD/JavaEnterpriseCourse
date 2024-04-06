package org.example.main.mapper;

import lombok.experimental.UtilityClass;
import org.example.main.dto.RoleDto;
import org.example.main.entity.Role;

@UtilityClass
public class RoleDtoMapper {
    public static RoleDto convertEntityToDto(Role source)
    {
        return RoleDto.builder()
                .title(source.getTitle())
                .id(source.getId())
                .build();
    }

    public static Role convertDtoToEntity(RoleDto source)
    {
        return Role.builder()
                .title(source.getTitle())
                .build();
    }
}
