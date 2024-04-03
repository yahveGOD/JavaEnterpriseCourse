package org.example.main.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {
    private long id;
    private int kills;
    private int deaths;
    private int assists;
    private int networth;
}
