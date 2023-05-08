package pl.carwebapp.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import pl.carwebapp.dto.CarDto;
import pl.carwebapp.dto.DateDto;
import pl.carwebapp.model.*;
import pl.carwebapp.service.CarService;

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

    @GetMapping("/load/car/{vin}")
    public Car loadCarByVin(@PathVariable String vin) {
        return service.getCarByVin(vin);
    }

    @PostMapping("/add")
    void addCarsDto(@RequestBody @Valid CarDto carDto) {
        service.addCars(carDto.getType(), carDto.getName(), carDto.getManufacturingYear(), carDto.getTransmission(), carDto.getFuelType(),
                carDto.getTypeOfDrive(), carDto.getPrice(), carDto.getMpg());
    }

    @PostMapping("/car/{vin}/updateRentalDate")
    void updateRentalDate(@RequestBody DateDto dateDto, @PathVariable String vin) {
        service.updateRentalDate(vin, dateDto.getLastServiceDate());
    }

    @DeleteMapping("/car/delete/{vin}")
    void deleteByVin(@PathVariable String vin) {
        service.deleteCar(vin);
    }

    @DeleteMapping("/delete")
    void delete() {
        service.deleteCars();
    }

    @GetMapping("/vin/{vin}")
    List<Car> byVin(@PathVariable String vin) {
        return service.filterByVin(vin);
    }

    @GetMapping("/name/{name}")
    List<Car> filterByName(@PathVariable String name) {
        return service.filterByName(name);
    }

    @GetMapping("/type/{type}")
    List<Car> filterByType(@PathVariable String type) {
        return service.filterByType(type);
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
