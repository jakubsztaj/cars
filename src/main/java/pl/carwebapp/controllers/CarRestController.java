package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.model.Car;
import pl.carwebapp.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")

public class CarRestController {

    CarService service;

    public CarRestController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public List<Car> returnCars() {
        return service.getCars();
    }

    @PostMapping("/add/{type}/{name}/{manufacturingYear}/{category}")
    void addCars(@PathVariable String name, @PathVariable String type, @PathVariable String manufacturingYear, @PathVariable String category) {
        service.addCars(type, name, manufacturingYear, category);
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

    @GetMapping("/name/{key}")
    List<Car> byName(@PathVariable String key) {
        return service.byName(key);
    }

    @GetMapping("/name/{key}/count")
    int byNameCount(@PathVariable String key) {
        return service.byName(key).size();
    }

    @GetMapping("/count/idle")
    int countIdleCars() {
        return service.count(car -> !car.isStarted());
    }

    @PostMapping("/car/rentall")
    void rentAllCars() {
        service.rentAllCars();
    }

    @PostMapping("/car/bringall")
    void bringBackAllCars() {
        service.bringBackCars();
    }

    @PostMapping("/car/rent/{vin}")
    void rentCar(@PathVariable String vin) {
        service.rentCar(vin);
    }

    @PostMapping("/car/bring/{vin}")
    void bringBackCar(@PathVariable String vin) {
        service.bringBackCar(vin);
    }
}
