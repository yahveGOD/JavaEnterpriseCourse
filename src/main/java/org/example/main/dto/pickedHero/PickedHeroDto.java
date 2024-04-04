package org.example.main.dto.pickedHero;

import lombok.*;
import org.example.main.dto.statistics.StatisticsDto;
import org.example.main.dto.user.UserDto;
import org.example.main.dto.hero.HeroDto;
import org.example.main.dto.inventory.InventoryDto;
import org.example.main.dto.match.MatchDto;

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
