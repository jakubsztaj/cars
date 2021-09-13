package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.dto.CarDto;
import pl.carwebapp.dto.DateDto;
import pl.carwebapp.model.*;
import pl.carwebapp.service.CarService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarRestController {

    CarService service;

    public CarRestController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public List<Car> returnCars() {
        return service.getCars();
    }

    @PostMapping("/add/{type}/{name}/{manufacturingYear}/{transmission}/{fuelType}/{typeOfDrive}/{doors}/{price}/{mpg}")
    void addCars(@PathVariable String name, @PathVariable String type, @PathVariable int manufacturingYear, @PathVariable Transmission transmission, @PathVariable FuelType fuelType, @PathVariable TypeOfDrive typeOfDrive, @PathVariable int price, @PathVariable double mpg) {
        service.addCars(type, name, manufacturingYear, transmission, fuelType, typeOfDrive, price, mpg);
    }

    @PostMapping("/add")
    void addCarsDto(@RequestBody @Valid CarDto carDto) {
        service.addCars(carDto.getType(), carDto.getName(), carDto.getManufacturingYear(), carDto.getTransmission(), carDto.getFuelType(), carDto.getTypeOfDrive(), carDto.getPrice(), carDto.getMpg());
    }

    @PostMapping("/car/{vin}/updateRentalDate")
    void updateRentalDate(@RequestBody DateDto dateDto, @PathVariable String vin) {
        service.updateRentalDate(vin, dateDto.getLastServiceDate());
    }

    @DeleteMapping("/delete")
    void delete() {
        service.deleteCars();
    }

    @DeleteMapping("/car/delete/{vin}")
    void deleteByVin(@PathVariable String vin) {
        service.deleteCar(vin);
    }

    @PostMapping("/engine/startall")
    void startAllCars() {
        service.startAllCars();
    }

    @PostMapping("/engine/stopall")
    void stopAllCars() {
        service.stopAllCars();
    }

    @PostMapping("/start/{vin}")
    void startSpecificCar(@PathVariable String vin) {
        service.startSpecificCar(vin);
    }

    @PostMapping("/stop/{vin}")
    void stopSpecificCar(@PathVariable String vin) {
        service.stopSpecificCar(vin);
    }

    @GetMapping("/vin/{vin}")
    List<Car> byVin(@PathVariable String vin) {
        return service.byVin(vin);
    }

    @GetMapping("/name/{name}")
    List<Car> filterByName(@PathVariable String name) {
        return service.filterByName(name);
    }

    @GetMapping("/type/{type}")
    List<Car> filterByType(@PathVariable String type) {
        return service.filterByType(type);
    }

    @GetMapping("/name/{key}/count")
    int byNameCount(@PathVariable String key) {
        return service.byName(key).size();
    }

    @GetMapping("/type/{type}/count")
    int byTypeCount(@PathVariable String type) {
        return service.byType(type).size();
    }

    @GetMapping("/count/idle")
    int countIdleCars() {
        return service.count(car -> !car.isStarted());
    }

    @GetMapping("/count/started")
    int countStartedCars() {
        return service.count(Car::isStarted);
    }

    @GetMapping("/count/rented")
    int countRentedCars() {
        return service.count(Car::isRented);
    }

    @GetMapping("/count")
    long getCarsCount() {
        return service.countCars();
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
