package org.example.main.repository;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.example.main.entity.Statistics;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StatisticsRepository extends AbstractRepository<Statistics> {

    public StatisticsRepository()
    {
        save(Statistics.builder()
                .assists(123)
                .deaths(123)
                .kills(123)
                .networth(1111111)
                .build());
        save(Statistics.builder()
                .assists(111)
                .deaths(111)
                .kills(111)
                .networth(333333)
                .build());
    }
}
