package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.carwebapp.model.Car;
import pl.carwebapp.model.Sedan;
import pl.carwebapp.model.Van;

import java.util.ArrayList;

@RestController
@RequestMapping("/cars")
public class CarRestController {
    ArrayList<Car> cars = new ArrayList<>();
    int index = 1;

    @GetMapping
    public ArrayList<Car> returnCars() {
        return this.cars;
    }

    @PostMapping("/add/{type}/{name}")
    void addCars(@PathVariable String name, @PathVariable String type) {
        Car car;
        if (type.equalsIgnoreCase("sedan")) {
            car = new Sedan(name + index++, type);
        } else if (type.equalsIgnoreCase("van")) {
            car = new Van(name + index++, type);
        } else {
            throw new IllegalArgumentException("Zły typ: " + type);
        }
        cars.add(car);

    }
    @DeleteMapping("/delete")
    void delete() {
        this.cars.clear();
    }
}
