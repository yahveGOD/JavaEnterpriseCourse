package org.example.main.dto.statistics;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsDto {
    private long uuid;
    private int kills;
    private int deaths;
    private int assists;
    private int networth;
}
