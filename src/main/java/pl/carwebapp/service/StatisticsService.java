package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import pl.carwebapp.data.StatisticsRepository;

@Service
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;

    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public StatisticsRepository getStatisticsRepository() {
        return statisticsRepository;
    }
}
