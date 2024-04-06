package org.example.main.dto;

import lombok.*;
import org.springframework.stereotype.Service;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private long id;
    private String title;
}
