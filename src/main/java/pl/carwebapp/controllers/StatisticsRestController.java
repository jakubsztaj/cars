package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.model.Car;
import pl.carwebapp.service.CarService;
import pl.carwebapp.service.RentalService;
import pl.carwebapp.service.RenterService;
import pl.carwebapp.service.StatisticsService;

@RestController
@RequestMapping("/stats")
@CrossOrigin
public class StatisticsRestController {
    StatisticsService statisticsService;

    CarService service;

    RenterService renterService;

    RentalService rentalService;

    public StatisticsRestController(StatisticsService statisticsService, CarService service, RenterService renterService, RentalService rentalService) {
        this.statisticsService = statisticsService;
        this.service = service;
        this.renterService = renterService;
        this.rentalService = rentalService;
    }

    @GetMapping("/name/{key}/count")
    int byNameCount(@PathVariable String key) {
        return service.byName(key).size();
    }

    @GetMapping("/type/{type}/count")
    int byTypeCount(@PathVariable String type) {
        return service.byType(type).size();
    }

    @GetMapping("/count/started")
    int countStartedCars() {
        return service.count(Car::isStarted);
    }

    @GetMapping("/count/rented")
    int countRentedCars() {
        return service.count(Car::isRented);
    }

    @GetMapping("/count/cars")
    long getCarsCount() {
        return service.countCars();
    }

    @GetMapping("/count/renters")
    long getRenterCount() {
        return renterService.countRenters();
    }

    @GetMapping("/count/rentals")
    long getRentalCount() {
        return rentalService.countRentals();
    }

}
