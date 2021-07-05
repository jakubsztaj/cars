package pl.carwebapp.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    CarService service = new CarService(null);

    @Test
    public void checkAddCar() {
        //given
        String type = "Van";
        String name = "2";
        String manufacturingYear = "2000";
        String category = "";
        // when
        service.addCars(type, name, manufacturingYear, category);
        // then
        assertEquals(service.getCars().size(), 1);
        assertEquals(service.getCars().get(0).getType(), type);
        assertEquals(service.getCars().get(0).getName(), name + "1");
    }

    @Test
    public void checkStartAllCars() {
        //given
        service.addCars("Van", "2", "2005","");
        service.addCars("Sedan", "3", "2001","");
        service.addCars("Hatchback", "1", "2004","");
        service.addCars("Suv", "0", "2009","");
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
        service.addCars("Van", "2", "2005","");
        service.addCars("Sedan", "3", "2053","");
        service.addCars("Hatchback", "1", "2001","");
        service.addCars("Suv", "0", "2005","");
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