package org.example.main.dto;

import lombok.*;
import org.example.main.entity.PickedHero;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsDto {
    private long id;
    private int kills;
    private int deaths;
    private int assists;
    private int networth;
    private List<PickedHeroDto> pickedHeroList;

}
