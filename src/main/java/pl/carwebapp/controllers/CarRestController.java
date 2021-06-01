package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.model.Car;
import pl.carwebapp.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")

public class CarRestController {

    CarService service = new CarService();

    @GetMapping
    public List<Car> returnCars() {
        return service.returnCars();
    }

    @PostMapping("/add/{type}/{name}")
    void addCars(@PathVariable String name, @PathVariable String type) {
        service.addCars(type, name);
    }

    @DeleteMapping("/delete")
    void delete() {
        service.deleteCars();
    }

    @PostMapping("/engine/startall")
    void startAllCars() {
        service.startAllCars();
    }

    @PostMapping("/engine/stopall")
    void stopAllCars() {
        service.stopAllCars();
    }

    @PostMapping("/start/{type}")
    void startSpecificType(@PathVariable String type) {
        service.startSpecificCar(type);
    }

    @PostMapping("/stop/{type}")
    void stopSpecificType(@PathVariable String type) {
        service.stopSpecificCar(type);
    }

    @GetMapping("/count/started")
    int countStartedCars() {
        return service.count(Car::isStarted);

    }

    @GetMapping("/count/idle")
    int countIdleCars() {
        return service.count(car -> !car.isStarted());
    }
}