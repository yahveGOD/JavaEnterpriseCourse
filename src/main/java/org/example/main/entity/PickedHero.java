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
public class PickedHero {
    private Hero hero;
    private User user;
    private Match match;
    private Statistics statistics;
    private Inventory inventory;
}
