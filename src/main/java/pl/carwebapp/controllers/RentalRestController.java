package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.dto.PaymentDto;
import pl.carwebapp.dto.RentalDto;
import pl.carwebapp.model.PaymentStatus;
import pl.carwebapp.model.Rental;
import pl.carwebapp.service.RentalService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Optional.ofNullable;

@RestController
@CrossOrigin
@RequestMapping("/rentals")
public class RentalRestController {
    RentalService rentalService;

    public RentalRestController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<Rental> returnRentals() {
        return rentalService.getAllRentals();
    }

    @PostMapping("/add")
    void createRental(@RequestBody RentalDto rentalDto) {
        LocalDateTime begin = ofNullable(rentalDto.getBegin()).orElseGet(LocalDateTime::now);
        LocalDateTime end = ofNullable(rentalDto.getEnd()).orElseGet(() -> begin.plusDays(3));
        BigDecimal deposit = ofNullable(rentalDto.getDeposit()).orElseGet(() -> BigDecimal.valueOf(5000));
        rentalService.createRental(rentalDto.getPesel(), rentalDto.getVin(), begin, end, deposit, rentalDto.getLocation());
    }

    @DeleteMapping("/delete")
    void delete() {
        rentalService.deleteRentals();
    }

    @GetMapping("/count")
    long getRentalCount() {
        return rentalService.countRentals();
    }

    @GetMapping("/active")
    public List<Rental> returnActiveRentals() {
        return rentalService.getActiveRentals();
    }

    @PostMapping("/payment/completed/{vin}")
    public void changePaymentStatus(@PathVariable String vin) {
        rentalService.changeStatus(vin);
    }

    @GetMapping("/{paymentStatus}")
    List<Rental> filterByStatus(@PathVariable PaymentStatus paymentStatus) {
        return rentalService.filterByStatus(paymentStatus);
    }

    @PostMapping("/payment/{rentalId}")
    public void addToBalance(@PathVariable String rentalId, @RequestBody @Valid PaymentDto dto) {
        rentalService.payForRental(rentalId, dto.getAmount());
    }
}
