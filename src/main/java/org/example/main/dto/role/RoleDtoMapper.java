package org.example.main.dto.role;

import lombok.experimental.UtilityClass;
import org.example.main.dto.role.RoleDto;
import org.example.main.entity.Role;

@UtilityClass
public class RoleDtoMapper {
    public static RoleDto convertEntityToDto(Role source)
    {
        return RoleDto.builder()
                .title(source.getTitle())
                .uuid(source.getId())
                .build();
    }

    public static Role convertDtoToEntity(RoleDto source)
    {
        return Role.builder()
                .title(source.getTitle())
                .build();
    }
}
