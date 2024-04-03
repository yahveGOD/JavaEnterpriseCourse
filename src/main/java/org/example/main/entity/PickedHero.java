package org.example.main.entity;

import lombok.*;

import java.util.Map;

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
