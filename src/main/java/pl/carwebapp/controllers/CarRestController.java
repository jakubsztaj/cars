package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.dto.CarDto;
import pl.carwebapp.dto.DateDto;
import pl.carwebapp.model.*;
import pl.carwebapp.service.CarService;
import pl.carwebapp.service.SearchService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarRestController {

    CarService service;

    SearchService searchService;

    public CarRestController(CarService service, SearchService searchService) {
        this.service = service;
        this.searchService = searchService;
    }

    @GetMapping
    public List<Car> returnCars() {
        return service.getCars();
    }

    @GetMapping("/load/car/{vin}")
    public Car getCarByVin(@PathVariable String vin) {
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

    @DeleteMapping("/delete")
    void delete() {
        service.deleteCars();
    }

    @DeleteMapping("/car/delete/{vin}")
    void deleteByVin(@PathVariable String vin) {
        service.deleteCar(vin);
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

    @GetMapping("/search/car/{phrase}")
    public List<Car> searchByPhrase(@PathVariable String phrase) {
        return searchService.searchCarByPhrase(phrase);
    }
}
