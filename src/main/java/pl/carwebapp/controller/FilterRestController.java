package pl.carwebapp.controller;

import org.springframework.web.bind.annotation.*;
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

    private final RentalService rentalService;

    public FilterRestController(CarService service, RentalService rentalService) {
        this.service = service;
        this.rentalService = rentalService;
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
        return service.filterByVin(vin);
    }

    @GetMapping("/{paymentStatus}")
    List<Rental> filterByStatus(@PathVariable PaymentStatus paymentStatus) {
        return rentalService.filterByStatus(paymentStatus);
    }

}


