package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.model.Rental;
import pl.carwebapp.service.RentalService;
import pl.carwebapp.service.SupportService;

@RestController
@CrossOrigin
@RequestMapping("/support")
public class SupportRestController {
    SupportService supportService;

    RentalService rentalService;

    public SupportRestController(SupportService supportService) {
        this.supportService = supportService;
    }

    @GetMapping("/testmail/{subject}/{text}")
    public void sendMessage(@PathVariable String subject, @PathVariable String text) {
        supportService.sendSimpleMessage(subject, text);
    }

    @GetMapping("/testmail/{location}")
    public void sendMessageAboutLocation(@PathVariable Rental location) {
        rentalService.notifyAboutCarLocation(location);
    }
}