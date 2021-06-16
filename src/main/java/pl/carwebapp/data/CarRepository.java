package pl.carwebapp.data;

import pl.carwebapp.model.Car;

import java.util.*;

public class CarRepository {
    ArrayList<Car> cars = new ArrayList<>();
    int index = 1;
    HashSet<String> carNames = new HashSet<>();
    HashMap<String, List<Car>> AmountOfCars = new HashMap<>();

    public int nextIndex() {
        return index++;
    }

    public void saveCar(Car car) {
        cars.add(car);
        carNames.add(car.getName());
        addCarByName(car);
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public void deleteCar() {
        this.cars.clear();
        carNames.clear();
    }

    public HashSet<String> getAllCarNames() {
        return carNames;
    }

    public void addCarByName(Car car) {
        String name = car.getName();
        if (AmountOfCars.containsKey(name)) {
            AmountOfCars.get(name).add(car);
        } else {
            ArrayList<Car> cars = new ArrayList<>();
            cars.add(car);
            AmountOfCars.put(name, cars);
        }
    }
    public List<Car> byName(String name) {
        return AmountOfCars.getOrDefault(name, Collections.emptyList());
    }
}
