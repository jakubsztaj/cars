package pl.carwebapp.service;

import org.junit.jupiter.api.Test;
import pl.carwebapp.model.FuelType;
import pl.carwebapp.model.Price;
import pl.carwebapp.model.Transmission;
import pl.carwebapp.model.TypeOfDrive;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    CarService service = new CarService(null);

    @Test
    public void checkAddCar() {
        //given
        String type = "Van";
        String name = "2";
        int manufacturingYear = 2006;
        Transmission transmission = Transmission.MANUAL;
        FuelType fuelType = FuelType.DIESEL;
        TypeOfDrive typeOfDrive = TypeOfDrive.AWD;
        Price price = Price.SMALL;
        double mpg = 20.8;

        // when
        service.addCars(type, name, manufacturingYear, transmission, fuelType, typeOfDrive, price, mpg);
        // then
        assertEquals(service.getCars().size(), 1);
        assertEquals(service.getCars().get(0).getType(), type);
        assertEquals(service.getCars().get(0).getName(), name + "1");
    }

    @Test
    public void checkStartAllCars() {
        //given
        service.addCars("Van", "2", 2006, Transmission.MANUAL, FuelType.DIESEL, TypeOfDrive.AWD, Price.LARGE, 20.7);
        service.addCars("Sedan", "3", 2006,Transmission.MANUAL,  FuelType.DIESEL, TypeOfDrive.AWD, Price.LARGE, 20.5);
        service.addCars("Hatchback", "1", 2005,Transmission.MANUAL, FuelType.DIESEL, TypeOfDrive.AWD, Price.LARGE, 20.5);
        service.addCars("Suv", "0", 2006,Transmission.MANUAL,  FuelType.DIESEL, TypeOfDrive.AWD, Price.LARGE, 20.5);
        // when
        service.startAllCars();
        // then
        assertTrue(service.getCars().get(0).isStarted());
        assertTrue(service.getCars().get(1).isStarted());
        assertTrue(service.getCars().get(2).isStarted());
        assertTrue(service.getCars().get(3).isStarted());
    }

    @Test
    public void checkStopAllCars() {
        //given
        service.addCars("Van", "2", 2006,Transmission.MANUAL, FuelType.DIESEL, TypeOfDrive.AWD, Price.LARGE, 20.5);
        service.addCars("Sedan", "3", 2006,Transmission.MANUAL,  FuelType.DIESEL, TypeOfDrive.AWD, Price.LARGE, 20.5);
        service.addCars("Hatchback", "1", 2006,Transmission.MANUAL,  FuelType.DIESEL, TypeOfDrive.AWD, Price.LARGE, 20.5);
        service.addCars("Suv", "0", 2006,Transmission.MANUAL,  FuelType.DIESEL, TypeOfDrive.AWD, Price.LARGE, 20.5);
        //and
        service.startAllCars();
        // when
        service.stopAllCars();
        // then
        assertFalse(service.getCars().get(0).isStarted());
        assertFalse(service.getCars().get(1).isStarted());
        assertFalse(service.getCars().get(2).isStarted());
        assertFalse(service.getCars().get(3).isStarted());
    }
}