package pl.carwebapp.controllers;

import org.junit.jupiter.api.Test;
import pl.carwebapp.model.Hatchback;
import pl.carwebapp.model.Sedan;
import pl.carwebapp.model.Van;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CarRestControllerTest {



    @Test
    void testStartCars() {
        // given
        CarRestController restController = new CarRestController();
        restController.cars.add(new Sedan());
        restController.cars.add(new Van());
        restController.cars.add(new Hatchback());
        // when
        restController.startAllCars();

        // then
        restController.cars.forEach(car-> assertTrue(car.isStarted()));
    }

}