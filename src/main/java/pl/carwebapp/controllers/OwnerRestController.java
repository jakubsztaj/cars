package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.dto.OwnerDto;
import pl.carwebapp.model.Owner;
import pl.carwebapp.service.OwnerService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/owners")
public class OwnerRestController {

    OwnerService service;

    public OwnerRestController(OwnerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Owner> returnOwners() {
        return service.getAllOwners();
    }

    @PostMapping("/add")
    void addOwnerDto(@RequestBody OwnerDto ownerDto) {
        service.addOwners(ownerDto.getOwnerName(), ownerDto.getOwnerLastName());
    }
}
