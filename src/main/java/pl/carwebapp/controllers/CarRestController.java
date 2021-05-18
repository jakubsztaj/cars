package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.carwebapp.model.Car;
import pl.carwebapp.model.Sedan;
import pl.carwebapp.model.Van;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    Map<String, Set<String>> databaseMap = new HashMap<>();
    Set<String> database1 = new HashSet<>();
    Set<Car> cars = new HashSet<>();

    @GetMapping("/brands")
    public Object brands() {
        Set<String> database = databaseMap.get("brands");
        database.add("audi");
        database.add("bmw");
        database.add("sedan");
        database.add("honda");
        database.add("hyundai");
        database.add("citroen");
        database.add("fiat");
        database.add("ford");
        database.add("nissan");
        return database;
    }

    @GetMapping("{type}/{name}")
    public Set<String> addType(@PathVariable String type, @PathVariable String name) {
        Car carToAdd = null;
        Set<String> database = databaseMap.get("cars");
        if (type.equals("sedan")) {
            Sedan sedan = new Sedan();
            sedan.setName("Sedan " + name);
            carToAdd = sedan;
        } else if (type.equals("van")) {
            Van van = new Van();
            van.setName("Van " + name);
            carToAdd = van;
        }

        if (carToAdd != null) {
            cars.add(carToAdd);
            database.add(carToAdd.toString());

        }
        return database;
    }

    @PostConstruct
    public void initializeDatabase() {
        databaseMap.put("brands", new TreeSet<>());
        databaseMap.put("cars", new HashSet<>());
    }
}
