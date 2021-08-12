package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.dto.RentalDto;
import pl.carwebapp.model.Rental;
import pl.carwebapp.service.RentalService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Optional.ofNullable;

@RestController
@CrossOrigin
@RequestMapping("/rentals")
public class RentalRestController {
    RentalService service;

    public RentalRestController(RentalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rental> returnRentals() {
        return service.getAllRentals();
    }

    @PostMapping("/add")
    void createRental(@RequestBody RentalDto rentalDto) {
        LocalDateTime begin = ofNullable(rentalDto.getBegin()).orElseGet(LocalDateTime::now);
        LocalDateTime end = ofNullable(rentalDto.getEnd()).orElseGet(() -> begin.plusDays(3));
        BigDecimal price = ofNullable(rentalDto.getPrice()).orElseGet(() -> BigDecimal.valueOf(200));
        service.createRental(rentalDto.getRenterId(), rentalDto.getVin(), begin, end, price);
    }

    @DeleteMapping("/delete")
    void delete() {
        service.deleteRentals();
    }
}
