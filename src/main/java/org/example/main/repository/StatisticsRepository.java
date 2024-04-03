package org.example.main.repository;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.example.main.entity.Statistics;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StatisticsRepository {
    @Getter
    private List<Statistics> statisticsList;

    public StatisticsRepository()
    {
        statisticsList = new ArrayList<>();
        Statistics statistics1 = new Statistics(0,10,20,1,5000);
        Statistics statistics2 = new Statistics(1,15,4,8,1500);
        statisticsList.add(statistics1);
        statisticsList.add(statistics2);
    }
}
