package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.carwebapp.service.StatisticsService;

@RestController
@RequestMapping("/stats")
@CrossOrigin
public class StatisticsRestController {
    StatisticsService statisticsService;

    public StatisticsRestController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }
}
