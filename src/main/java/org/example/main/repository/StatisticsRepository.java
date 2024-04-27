package org.example.main.repository;

import org.example.main.entity.Statistics;
import org.example.main.repository.AbstractHibernateRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StatisticsRepository extends AbstractHibernateRepository<Statistics>{
    public StatisticsRepository()
    {
        super(Statistics.class);
    }
}
