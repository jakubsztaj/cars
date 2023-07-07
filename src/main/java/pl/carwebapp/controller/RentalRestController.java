package pl.carwebapp.controller;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.dto.RentalDto;
import pl.carwebapp.model.PaymentStatus;
import pl.carwebapp.model.Rental;
import pl.carwebapp.service.RentalService;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeoutException;

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

    @GetMapping("/active")
    public List<Rental> returnActiveRentals() {
        return rentalService.getActiveRentals();
    }

//    @GetMapping("/send")
//    public String sendMessage() throws IOException, TimeoutException {
//        rentalService.sendRentalInformationMessage();
//        return "Message published";
//    }

    @GetMapping("/receive")
    public String receiveMessage() throws Exception {
        rentalService.receiveRentalData();
        return "Message received";
    }

    @PostMapping("/add")
    void createRental(@RequestBody RentalDto rentalDto) throws Exception {
        LocalDateTime begin = ofNullable(rentalDto.getBegin()).orElseGet(LocalDateTime::now);
        LocalDateTime end = ofNullable(rentalDto.getEnd()).orElseGet(() -> begin.plusDays(3));
        BigDecimal deposit = ofNullable(rentalDto.getDeposit()).orElseGet(() -> BigDecimal.valueOf(500));
        rentalService.createRental(rentalDto.getPesel(), rentalDto.getVin(), begin, end, deposit, rentalDto.getLocation());
    }

    @DeleteMapping("/delete")
    void delete() {
        rentalService.deleteRentals();
    }

    @PostMapping("/payment/completed/{vin}")
    public void changePaymentStatus(@PathVariable String vin) {
        rentalService.changeStatus(vin);
    }

    @GetMapping("/{paymentStatus}")
    List<Rental> filterByStatus(@PathVariable PaymentStatus paymentStatus) {
        return rentalService.filterByStatus(paymentStatus);
    }

    @GetMapping("/count")
    long getRentalCount() {
        return rentalService.countRentals();
    }
}
