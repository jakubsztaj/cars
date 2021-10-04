package pl.carwebapp.service;

import org.junit.jupiter.api.Test;
import pl.carwebapp.model.FuelType;
import pl.carwebapp.model.Transmission;
import pl.carwebapp.model.TypeOfDrive;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    CarService service = new CarService(null, null);

    @Test
    public void checkAddCar() {
        //given
        String type = "Van";
        String name = "2";
        int manufacturingYear = 2006;
        Transmission transmission = Transmission.MANUAL;
        FuelType fuelType = FuelType.DIESEL;
        TypeOfDrive typeOfDrive = TypeOfDrive.AWD;
        int price = 50;
        double mpg = 20.8;

        // when
        service.addCars(type, name, manufacturingYear, transmission, fuelType, typeOfDrive, price, mpg);
        // then
        assertEquals(service.getCars().size(), 1);
        assertEquals(service.getCars().get(0).getType(), type);
        assertEquals(service.getCars().get(0).getName(), name + "1");
    }
}