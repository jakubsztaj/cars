package pl.carwebapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.carwebapp.model.Car;
import pl.carwebapp.model.Sedan;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    @GetMapping("/hello")
    public String hello() {
        return "Kuba";
    }

    @GetMapping("/siema")
    public List<String> siema() {
        List<String> list = new ArrayList<>();
        list.add("audi");
        list.add("bmw");
        list.add("opel");
        return list;
    }

    @GetMapping("/sedan/{number}")
    public Car getSedan(@PathVariable("number") String number) {
        Sedan sedan = new Sedan();
        sedan.setName("Opel" + number);
        return  sedan;
    }
}
