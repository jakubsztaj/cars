package pl.carwebapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.carwebapp.model.*;

import java.util.ArrayList;
import java.util.Iterator;

@RestController
@RequestMapping("/cars")

public class CarRestController {
    ArrayList<Car> cars = new ArrayList<>();
    int index = 1;
    Logger logger = LoggerFactory.getLogger(CarRestController.class);

    @GetMapping
    public ArrayList<Car> returnCars() {
        // logger.info("returning cars");
        // logger.debug("returning cars");
        // logger.warn("returning cars");
        // logger.error("returning cars");
        // logger.trace("returning cars");
        return this.cars;
    }

    @PostMapping("/add/{type}/{name}")
    void addCars(@PathVariable String name, @PathVariable String type) {
        Car car;
        if (type.equalsIgnoreCase("sedan")) {
            car = new Sedan(name + index++, type);
        } else if (type.equalsIgnoreCase("van")) {
            car = new Van(name + index++, type);
        } else if (type.equalsIgnoreCase("suv")) {
            car = new Suv(name + index++, type);
            car = new Hatchback(name + index++, type);
        } else {
            logger.error("Zly typ: {} ", type);
            throw new IllegalArgumentException("Zły typ: " + type);
        }
        logger.info("added car: {}", car);
        cars.add(car);
    }

    @DeleteMapping("/delete")
    void delete() {
        this.cars.clear();
    }

    @PostMapping("/engine/startall")
    void startAllCars() {
        for (Car car : cars) {
            car.startEngine();
        }

    }

    @PostMapping("/engine/stopall")
    void stopAllCars() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    @PostMapping("/start/{type}")
    void startSpecificType(@PathVariable String type) {
        for (Car car : cars) {
            if (car.getType().equalsIgnoreCase(type)) {
                car.startEngine();
            }

        }
    }

    @PostMapping("/stop/{type}")
    void stopSpecificType(@PathVariable String type) {
        for (Car car : cars) {
            if (car.getType().equalsIgnoreCase(type)) {
                car.stopEngine();
            }

        }
    }

    @GetMapping("/count")
    int countStartedCars() {
        int startedCars = 0;
        int i = 0;
        while (i < cars.size()) {
            Car car = cars.get(i);
            if (car.isStarted()) {
                startedCars++;
            }
            i++;
        }
        return startedCars;
    }

    @GetMapping("/count1")
    int countStartedCars1() {
        int startedCars = 0;
        int i = 0;
        do {
            Car car = cars.get(i);
            if (car.isStarted()) {
                startedCars++;
            }
            i++;
        }
        while (i < cars.size());
        return startedCars;
    }

    @GetMapping("/count2")
    int countStartedCars2() {
        int startedCars = 0;

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.isStarted()) {
                startedCars++;

            }
        }
        return startedCars;
    }

    @GetMapping("/count3")
    int countStartedCars3() {
        int startedCars = 0;
        for (Car car : cars) {
            if (car.isStarted()) {
                startedCars++;
            }
        }
        return startedCars;
    }

    @GetMapping("/count4")
    int countStartedCars4() {
        int startedCars = 0;
        Iterator<Car> carIterator = cars.iterator();
        while (carIterator.hasNext()) {
            Car car = carIterator.next();
            if (car.isStarted()) {
                startedCars++;
            }
        }
        return startedCars;
    }

    @GetMapping("/count5")
    int countStartedCars5() {
        return (int) cars.stream()
                .filter(Car::isStarted)
                .count();
    }
}