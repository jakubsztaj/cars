package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import pl.carwebapp.data.CarRepository;
import pl.carwebapp.model.*;
import pl.carwebapp.util.DataGenerator;

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

    public void addCars(String type, String name, int manufacturingYear, Transmission transmission, FuelType fuelType, TypeOfDrive typeOfDrive, int price, double mpg) {

        Car car;

        if (type.equalsIgnoreCase("sedan")) {
            car = new Car(name, type, manufacturingYear, Segment.D, DataGenerator.randomPlatesNumber(), DataGenerator.randomizeVin(), transmission, fuelType,
                    typeOfDrive, 5, price, mpg, 5);
        } else if (type.equalsIgnoreCase("van")) {
            car = new Car(name, type, manufacturingYear, Segment.M, DataGenerator.randomPlatesNumber(), DataGenerator.randomizeVin(), transmission, fuelType,
                    typeOfDrive, 4, price, mpg, 7);
        } else if (type.equalsIgnoreCase("suv")) {
            car = new Car(name, type, manufacturingYear, Segment.J, DataGenerator.randomPlatesNumber(), DataGenerator.randomizeVin(), transmission, fuelType,
                    typeOfDrive, 5, price, mpg, 5);
        } else if (type.equalsIgnoreCase("hatchback")) {
            car = new Car(name, type, manufacturingYear, Segment.C, DataGenerator.randomPlatesNumber(), DataGenerator.randomizeVin(), transmission, fuelType,
                    typeOfDrive, 5, price, mpg, 5);
        } else if (type.equalsIgnoreCase("prestige")) {
            car = new Car(name, type, manufacturingYear, Segment.F, DataGenerator.randomPlatesNumber(), DataGenerator.randomizeVin(), transmission, fuelType,
                    typeOfDrive, 3, price, mpg, 5);
        } else if (type.equalsIgnoreCase("track")) {
            car = new Car(name, type, manufacturingYear, Segment.A, DataGenerator.randomPlatesNumber(), DataGenerator.randomizeVin(), transmission, fuelType,
                    typeOfDrive, 4, price, mpg, 5);
        } else {
            throw new IllegalArgumentException("Zły typ: " + type);
        }
        repository.save(car);
    }

    public List<Car> getCars() {
        return repository.findAll();
    }

    public Car getCarByVin(String vin) {
        return repository.findByVin(vin).orElseThrow(IllegalStateException::new);
    }

    public void deleteCar(String vin) {
        repository.findByVin(vin).ifPresent(car -> {
            if (car.getVin().equalsIgnoreCase(vin)) {
                repository.delete(car);
            }
        });
    }

    public void deleteCars() {
        repository.deleteAll();
    }

    public void updateRentalDate(String vin, LocalDate date) {
        repository.findByVin(vin).ifPresent(car -> {
            car.updateRentalDate(date);
            repository.save(car);
        });
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

    public List<Car> filterByVin(String vin) {
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

    public int count(Predicate<Car> carPredicate) {
        return (int) repository.findAll().stream()
                .filter(carPredicate)
                .count();
    }

    public int countCars() {
        return (int) repository.count();
    }
}
