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

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    Logger logger = LoggerFactory.getLogger(CarService.class);

    public void addCars(String type, String name, String manufacturingYear, String category) {

        Car car;
        boolean b = category.equals("A") || category.equals("B") || category.equals("C");
        if (type.equalsIgnoreCase("sedan") && b) {
            car = new Sedan(name, type, manufacturingYear, category);
        } else if (type.equalsIgnoreCase("van") && b) {
            car = new Van(name, type, manufacturingYear, category);
        } else if (type.equalsIgnoreCase("suv") && b) {
            car = new Suv(name, type, manufacturingYear, category);
        } else if (type.equalsIgnoreCase("hatchback") && b) {
            car = new Hatchback(name, type, manufacturingYear, category);
        } else {
            logger.error("Zly typ: {} ", type);
            throw new IllegalArgumentException("Zły typ: " + type);
        }
        logger.info("added car: {}", car);
        repository.save(car);
    }

    public List<Car> getCars() {
        return repository.findAll();
    }

    public void deleteCars() {
        repository.deleteAll();
    }

    public int count(Predicate<Car> carPredicate) {
        return (int) repository.findAll().stream()
                .filter(carPredicate)
                .count();
    }

    public void startAllCars() {
        repository.findAll().forEach(car -> {
            car.startEngine();
            repository.save(car);
        });
    }

    public void stopAllCars() {
        repository.findAll().forEach(car -> {
            car.stopEngine();
            repository.save(car);
        });

    }

    public void startSpecificCar(String type) {
        repository.findAll().forEach(car -> {
            if (car.getType().equalsIgnoreCase(type)) {
                car.startEngine();
                repository.save(car);
            }
        });
    }

    public void stopSpecificCar(String type) {
        repository.findAll().forEach(car -> {
            if (car.getType().equalsIgnoreCase(type)) {
                car.stopEngine();
                repository.save(car);
            }
        });
    }

    public void rentAllCars() {
        repository.findAll().forEach(car -> {
            car.rentCar();
            repository.save(car);
        });
    }

    public void bringBackCars() {
        repository.findAll().forEach(car -> {
            car.bringBackCar();
            repository.save(car);
        });
    }

    public List<Car> byName(String name) {
        return repository.findByName(name);
    }

    public void rentCar(String vin) {
        repository.findByVin(vin).ifPresent(car -> {
            car.rentCar();
            repository.save(car);
        });

    }

    public void bringBackCar(String vin) {
        repository.findByVin(vin).ifPresent(car -> {
            car.bringBackCar();
            repository.save(car);
        });
    }
}
