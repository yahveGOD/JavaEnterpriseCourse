package org.example.main.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    private String name;
    private String password;
    private String steamApiKey;
    private String description;
    private int averageMatchmakingRating;
}
