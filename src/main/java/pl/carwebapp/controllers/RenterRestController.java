package pl.carwebapp.controllers;


import org.springframework.web.bind.annotation.*;
import pl.carwebapp.model.Renter;
import pl.carwebapp.service.RenterService;

import java.util.List;

@RestController
@RequestMapping("/renters")
@CrossOrigin
public class RenterRestController {
    RenterService service;

    public RenterRestController(RenterService service) {
        this.service = service;
    }

    @GetMapping
    public List<Renter> returnRenters() {
        return service.getAllRenters();
    }

    @PostMapping("/add/{renterName}/{renterLastName}")
    void addRenters(@PathVariable String renterName, @PathVariable String renterLastName) {
        service.addRenters(renterName, renterLastName);
    }

}
