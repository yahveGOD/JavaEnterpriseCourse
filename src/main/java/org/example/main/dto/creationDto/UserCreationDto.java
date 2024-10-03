package org.example.main.dto.creationDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDto {
    private String name;
    private String password;
    private String steamApiKey;
    private String description;
    private Integer averageMatchmakingRating;
}
