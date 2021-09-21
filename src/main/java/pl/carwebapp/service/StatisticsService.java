package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import pl.carwebapp.data.CarRepository;
import pl.carwebapp.data.StatisticsRepository;

@Service
public class StatisticsService {
    private final StatisticsRepository statisticsRepository;

    private final CarService service;

    private final CarRepository repository;

    public StatisticsService(StatisticsRepository statisticsRepository, CarService service, CarRepository repository) {
        this.statisticsRepository = statisticsRepository;
        this.service = service;
        this.repository = repository;
    }

    public StatisticsRepository getStatisticsRepository() {
        return statisticsRepository;
    }

    public CarService getService() {
        return service;
    }

    public CarRepository getRepository() {
        return repository;
    }

}
