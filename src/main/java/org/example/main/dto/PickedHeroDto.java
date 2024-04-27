package org.example.main.dto;

import jakarta.persistence.*;
import lombok.*;
import org.example.main.entity.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PickedHeroDto {
    private List<HeroDto> heroes;
    private UserDto user;
    private List<MatchDto> matches;
    private StatisticsDto statistics;
    private InventoryDto inventory;
}
