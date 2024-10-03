package org.example.main.dto.creationDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsCreationDto {
    private int kills;
    private int deaths;
    private int assists;
    private int networth;
}
