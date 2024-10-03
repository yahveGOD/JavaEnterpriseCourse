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
    private Long id;
    private String title;
    private List<UserDto> users;

}
