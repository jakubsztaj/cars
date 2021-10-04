package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.data.CarRepository;
import pl.carwebapp.data.RentalRepository;
import pl.carwebapp.model.Car;
import pl.carwebapp.model.PaymentStatus;
import pl.carwebapp.model.Rental;
import pl.carwebapp.service.CarService;
import pl.carwebapp.service.RentalService;

import java.util.List;

@RestController
@RequestMapping("/filter")
@CrossOrigin
public class FilterRestController {

    private final CarService service;

    private final CarRepository repository;

    private final RentalService rentalService;

    private final RentalRepository rentalRepository;


    public FilterRestController(CarService service, CarRepository repository, RentalService rentalService, RentalRepository rentalRepository) {
        this.service = service;
        this.repository = repository;
        this.rentalService = rentalService;
        this.rentalRepository = rentalRepository;
    }

    @GetMapping("/{type}")
    List<Car> filterByType(@PathVariable String type) {
        return service.filterByType(type);
    }

    @GetMapping("/{name}")
    List<Car> filterByName(@PathVariable String name) {
        return service.filterByName(name);
    }

    @GetMapping("/vin/{vin}")
    List<Car> byVin(@PathVariable String vin) {
        return service.byVin(vin);
    }

    @GetMapping("/{paymentStatus}")
    List<Rental> filterByStatus(@PathVariable PaymentStatus paymentStatus) {
        return rentalService.filterByStatus(paymentStatus);
    }

}


