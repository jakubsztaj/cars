package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.carwebapp.dto.CountDto;
import pl.carwebapp.model.Car;
import pl.carwebapp.service.CarService;
import pl.carwebapp.service.RentalService;
import pl.carwebapp.service.RenterService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stats")
@CrossOrigin
public class StatisticsRestController {
    CarService service;

    RenterService renterService;

    RentalService rentalService;

    public StatisticsRestController(CarService service, RenterService renterService, RentalService rentalService) {
        this.service = service;
        this.renterService = renterService;
        this.rentalService = rentalService;
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

        countDtoList.add(new CountDto("All Cars", service.countCars()));
        countDtoList.add(new CountDto("All Renters", renterService.countRenters()));
        countDtoList.add(new CountDto("All Rentals", rentalService.countRentals()));
        countDtoList.add(new CountDto("Rented Cars", service.count(Car::isRented)));

        return countDtoList;
    }
}
