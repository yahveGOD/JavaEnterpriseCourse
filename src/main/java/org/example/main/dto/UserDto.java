package org.example.main.dto;

import jakarta.persistence.*;
import lombok.*;
import org.example.main.entity.Match;
import org.example.main.entity.PickedHero;
import org.example.main.entity.Role;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private String password;
    private String steamApiKey;
    private String description;
    private int averageMatchmakingRating;
    private List<MatchDto> matches;
    private List<RoleDto> roles;
    private List<PickedHeroDto> pickedHeroes;
}
