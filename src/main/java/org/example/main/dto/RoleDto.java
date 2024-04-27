package org.example.main.dto;

import lombok.*;
import org.example.main.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private long id;
    private String title;
    List<UserDto> users;

}
