package org.example.main.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PickedHeroDto {
    private HeroDto hero;
    private UserDto user;
    private MatchDto match;
    private StatisticsDto statistics;
    private InventoryDto inventory;
}
