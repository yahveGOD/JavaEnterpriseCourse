package org.example.main.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"user\"")
public class User extends BaseEntity {
    @ManyToMany(mappedBy = "users",fetch = FetchType.LAZY)
    private List<Match> matches;

    @JoinTable(
            name = "users_roles",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Role> roles;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<PickedHero> pickedHeroes;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "steam_api_key")
    private String steamApiKey;

    @Column(name = "description")
    private String description;

    @Column(name = "average_matchmaking_rating")
    private Integer averageMatchmakingRating;
}
