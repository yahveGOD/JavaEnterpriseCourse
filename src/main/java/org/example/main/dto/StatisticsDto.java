package org.example.main.dto;

import lombok.*;

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
}
