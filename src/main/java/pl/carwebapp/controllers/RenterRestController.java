package pl.carwebapp.controllers;


import org.springframework.web.bind.annotation.*;
import pl.carwebapp.dto.RenterDto;
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

    @PostMapping("/add")
    void addRentersDto(@RequestBody RenterDto renterDto) {
        service.addRenters(renterDto.getRenterName(), renterDto.getRenterLastName());
    }

    @DeleteMapping("/delete")
    void delete() {
        service.deleteRenters();
    }

    @DeleteMapping("/renter/delete/{pesel}")
    void deleteByPesel(@PathVariable String pesel) {
        service.deleteRenter(pesel);
    }

    @GetMapping("/pesel/{pesel}")
    List<Renter> filterByPesel(@PathVariable String pesel) {
        return service.byPesel(pesel);
    }

    @GetMapping("/count")
    long getRenterCount() {
        return service.countRenters();
    }
}
