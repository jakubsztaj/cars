package pl.carwebapp.data;

import org.springframework.stereotype.Component;
import pl.carwebapp.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarRepository {
    ArrayList<Car> cars = new ArrayList<>();
    int index = 1;

    public int nextIndex() {
        return index++;
    }

    public void saveCar(Car car) {
        cars.add(car);
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public void deleteCar() {
        this.cars.clear();
    }
}
