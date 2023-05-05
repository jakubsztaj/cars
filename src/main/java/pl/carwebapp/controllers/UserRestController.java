package pl.carwebapp.controllers;


import org.springframework.web.bind.annotation.*;
import pl.carwebapp.dto.UserDto;
import pl.carwebapp.model.User;
import pl.carwebapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/renters")
@CrossOrigin
public class UserRestController {
    UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> returnRenters() {
        return userService.getAllRenters();
    }

    @GetMapping("/load/renter/{pesel}")
    public User loadRenterByPesel(@PathVariable String pesel) {
        return userService.getRenterByPesel(pesel);
    }

    @PostMapping("/add")
    void addRentersDto(@RequestBody UserDto userDto) {
        userService.addRenters(userDto.getRenterName(), userDto.getRenterLastName(), userDto.getRenterPlaceOfResidence(), userDto.getRenterLogin(), userDto.getRenterPassword());
    }

    @DeleteMapping("/delete/{pesel}")
    void deleteByPesel(@PathVariable String pesel) {
        userService.deleteRenter(pesel);
    }

    @DeleteMapping("/delete")
    void delete() {
        userService.deleteRenters();
    }

    @GetMapping("/pesel/{pesel}")
    List<User> filterByPesel(@PathVariable String pesel) {
        return userService.byPesel(pesel);
    }

    @GetMapping("/lastName/{lastName}")
    List<User> filterByLastName(@PathVariable String lastName) {
        return userService.byLastName(lastName);
    }

    @GetMapping("/placeOfResidence/{placeOfResidence}")
    List<User> filterByPlaceOfResidence(@PathVariable String placeOfResidence) {
        return userService.byPlaceOfResidence(placeOfResidence);
    }

    @GetMapping("/count")
    long getRenterCount() {
        return userService.countRenters();
    }
}
