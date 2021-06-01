package pl.carwebapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.carwebapp.data.CarRepository;
import pl.carwebapp.model.*;

import java.util.List;
import java.util.function.Predicate;

@Service
public class CarService {
    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    private CarRepository repository;

    Logger logger = LoggerFactory.getLogger(CarService.class);

    public void addCars(String type, String name) {

        Car car;
        if (type.equalsIgnoreCase("sedan")) {
            car = new Sedan(name + repository.nextIndex(), type);
        } else if (type.equalsIgnoreCase("van")) {
            car = new Van(name + repository.nextIndex(), type);
        } else if (type.equalsIgnoreCase("suv")) {
            car = new Suv(name + repository.nextIndex(), type);
            car = new Hatchback(name + repository.nextIndex(), type);
        } else {
            logger.error("Zly typ: {} ", type);
            throw new IllegalArgumentException("Zły typ: " + type);
        }
        logger.info("added car: {}", car);
        repository.saveCar(car);
    }

    public List<Car> returnCars() {
        return repository.getAllCars();
    }

    public void deleteCars() {
        repository.deleteCar();
    }

    public int count(Predicate<Car> carPredicate) {
        return (int) repository.getAllCars().stream()
                .filter(carPredicate)
                .count();
    }

    public void startAllCars() {
        repository.getAllCars().forEach(Car::startEngine);
    }

    public void stopAllCars() {
        repository.getAllCars().forEach(Car::stopEngine);
    }

    public void startSpecificCar(String type) {
        repository.getAllCars().forEach(car -> {
            if (car.getType().equalsIgnoreCase(type)) {
                car.startEngine();
            }
        });
    }

    public void stopSpecificCar(String type) {
        repository.getAllCars().forEach(car -> {
            if (car.getType().equalsIgnoreCase(type)) {
                car.stopEngine();
            }
        });
    }
}
