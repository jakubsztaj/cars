package pl.carwebapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.carwebapp.data.CarRepository;
import pl.carwebapp.model.*;
import pl.carwebapp.util.CarDataGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    Logger logger = LoggerFactory.getLogger(CarService.class);

    public void addCars(String type, String name, int manufacturingYear, Transmission transmission, FuelType fuelType, TypeOfDrive typeOfDrive, Price price, double mpg) {

        Car car;

        if (type.equalsIgnoreCase("sedan")) {
            car = new Sedan(name, type, manufacturingYear, CarDataGenerator.randomPlatesNumber(), CarDataGenerator.randomizeVin(), transmission, fuelType, typeOfDrive, 5, price, mpg, 5);
        } else if (type.equalsIgnoreCase("van")) {
            car = new Van(name, type, manufacturingYear, CarDataGenerator.randomPlatesNumber(), CarDataGenerator.randomizeVin(), transmission, fuelType, typeOfDrive, 4, price, mpg, 7);
        } else if (type.equalsIgnoreCase("suv")) {
            car = new Suv(name, type, manufacturingYear, CarDataGenerator.randomPlatesNumber(), CarDataGenerator.randomizeVin(), transmission, fuelType, typeOfDrive, 5, price, mpg, 5);
        } else if (type.equalsIgnoreCase("hatchback")) {
            car = new Hatchback(name, type, manufacturingYear, CarDataGenerator.randomPlatesNumber(), CarDataGenerator.randomizeVin(), transmission, fuelType, typeOfDrive, 5, price, mpg, 5);
        } else if (type.equalsIgnoreCase("prestige")) {
            car = new Prestige(name, type, manufacturingYear, CarDataGenerator.randomPlatesNumber(), CarDataGenerator.randomizeVin(), transmission, fuelType, typeOfDrive, 3, price, mpg, 5);
        } else if (type.equalsIgnoreCase("track")) {
            car = new Track(name, type, manufacturingYear, CarDataGenerator.randomPlatesNumber(), CarDataGenerator.randomizeVin(), transmission, fuelType, typeOfDrive, 4, price, mpg, 5);
        } else if (type.equalsIgnoreCase("sportscar")) {
            car = new SportsCar(name, type, manufacturingYear, CarDataGenerator.randomPlatesNumber(), CarDataGenerator.randomizeVin(), transmission, fuelType, typeOfDrive, 3, price, mpg, 2);
        } else {
            logger.error("Zly typ: {} ", type);
            throw new IllegalArgumentException("Zły typ: " + type);
        }
        repository.save(car);

        logger.info("added car: {}", car);

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

    public void startSpecificCar(String vin) {
        repository.findByVin(vin).ifPresent(car -> {
            if (car.getVin().equalsIgnoreCase(vin)) {
                car.startEngine();
                repository.save(car);
            }
        });
    }

    public void deleteCar(String vin) {
        repository.findByVin(vin).ifPresent(car -> {
            if (car.getVin().equalsIgnoreCase(vin)) {
                repository.delete(car);
            }
        });
    }

    public void stopSpecificCar(String vin) {
        repository.findByVin(vin).ifPresent(car -> {
            if (car.getVin().equalsIgnoreCase(vin)) {
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

    public List<Car> byType(String type) {
        return repository.findByType(type);
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

    public List<Car> byVin(String vin) {
        return repository.findAll().stream()
                .filter(car -> car.getVin().toLowerCase(Locale.ROOT).startsWith(vin.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    public List<Car> filterByName(String name) {
        return repository.findAll().stream()
                .filter(car -> car.getName().toLowerCase(Locale.ROOT).startsWith(name))
                .collect(Collectors.toList());
    }

    public List<Car> filterByType(String type) {
        return repository.findAll().stream()
                .filter(car -> car.getType().toLowerCase(Locale.ROOT).startsWith(type))
                .collect(Collectors.toList());
    }

    public void updateRentalDate(String vin, LocalDate date) {
        repository.findByVin(vin).ifPresent(car -> {
            car.updateRentalDate(date);
            repository.save(car);
        });
    }

    public long countCars() {
        return repository.count();
    }
}
