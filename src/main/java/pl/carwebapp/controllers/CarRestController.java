package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.model.Car;
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

    @PostMapping("/add/{type}/{name}/{manufacturingYear}/{category}")
    void addCars(@PathVariable String name, @PathVariable String type, @PathVariable int manufacturingYear, @PathVariable String category) {
        service.addCars(type, name, manufacturingYear, category);
    }

    @PostMapping("/add")
    void addCarsDto(@RequestBody CarDto carDto) {
        service.addCars(carDto.getType(), carDto.getName(), carDto.getManufacturingYear(), carDto.getCategory());
    }

    @DeleteMapping("/delete")
    void delete() {
        service.deleteCars(); }


    @DeleteMapping("/car/delete/{vin}")
    void deleteByVin(@PathVariable String vin) {
        service.deleteCar(vin); }

    @PostMapping("/engine/startall")
    void startAllCars() {
        service.startAllCars();
    }

    @PostMapping("/engine/stopall")
    void stopAllCars() {
        service.stopAllCars();
    }

    @PostMapping("/start/{vin}")
    void startSpecificType(@PathVariable String vin) {
        service.startSpecificCar(vin);
    }

    @PostMapping("/stop/{vin}")
    void stopSpecificType(@PathVariable String vin) {
        service.stopSpecificCar(vin);
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

    public static class CarDto {
        String name;
        String type;
        int manufacturingYear;
        String category;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getManufacturingYear() {
            return manufacturingYear;
        }

        public void setManufacturingYear(int manufacturingYear) {
            this.manufacturingYear = manufacturingYear;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }
}
