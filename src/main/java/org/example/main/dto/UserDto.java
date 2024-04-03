package org.example.main.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long uuid;
    private String name;
    private String password;
    private String steamApiKey;
    private String description;
    private int averageMatchmakingRating;
}
