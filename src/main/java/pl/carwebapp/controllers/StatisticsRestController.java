package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.dto.CountDto;
import pl.carwebapp.model.Car;
import pl.carwebapp.service.CarService;
import pl.carwebapp.service.RentalService;
import pl.carwebapp.service.RenterService;
import pl.carwebapp.service.StatisticsService;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/")
    public List<CountDto> getCompleteStatistics() {
        List<CountDto> countDtoList = new ArrayList<>();

        countDtoList.add(new CountDto("Started Cars", service.count(Car::isStarted)));
        countDtoList.add(new CountDto("All Cars", service.countCars()));
        countDtoList.add(new CountDto("Rented Cars", service.count(Car::isRented)));
        countDtoList.add(new CountDto("All Rentals", rentalService.countRentals()));
        countDtoList.add(new CountDto("All Renters", renterService.countRenters()));

        return countDtoList;
    }

}
