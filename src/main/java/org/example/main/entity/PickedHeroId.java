package org.example.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PickedHeroId implements Serializable {
    @Column(name = "hero_id")
    private Long heroId;
    @Column(name = "match_id")
    private Long matchId;
}
