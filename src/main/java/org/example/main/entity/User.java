package org.example.main.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private String password;
    private String steamApiKey;
    private String description;
    private int averageMatchmakingRating;
}
