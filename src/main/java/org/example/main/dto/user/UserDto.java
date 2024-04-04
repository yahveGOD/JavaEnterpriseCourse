package org.example.main.dto.user;

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
