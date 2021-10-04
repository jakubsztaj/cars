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
    RenterService renterService;

    public RenterRestController(RenterService renterService) {
        this.renterService = renterService;
    }

    @GetMapping
    public List<Renter> returnRenters() {
        return renterService.getAllRenters();
    }

    @GetMapping("/load/renter/{pesel}")
    public Renter loadRenterByPesel(@PathVariable String pesel) {
       return renterService.getRenterByPesel(pesel);
    }

    @PostMapping("/add")
    void addRentersDto(@RequestBody RenterDto renterDto) {
        renterService.addRenters(renterDto.getRenterName(), renterDto.getRenterLastName(), renterDto.getRenterPlaceOfResidence());
    }

    @DeleteMapping("/delete")
    void delete() {
        renterService.deleteRenters();
    }

    @DeleteMapping("/delete/{pesel}")
    void deleteByPesel(@PathVariable String pesel) {
        renterService.deleteRenter(pesel);
    }

    @GetMapping("/pesel/{pesel}")
    List<Renter> filterByPesel(@PathVariable String pesel) {
        return renterService.byPesel(pesel);
    }

    @GetMapping("/count")
    long getRenterCount() {
        return renterService.countRenters();
    }
}
