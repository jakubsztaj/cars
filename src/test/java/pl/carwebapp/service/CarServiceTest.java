package pl.carwebapp.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    CarService service = new CarService();

    @Test
    public void checkAddCar() {
        //given
        String type = "Van";
        String name = "2";
        // when
        service.addCars(type, name);
        // then
        assertEquals(service.returnCars().size(), 1);
        assertEquals(service.returnCars().get(0).getType(), type);
        assertEquals(service.returnCars().get(0).getName(), name + "1");
    }

    @Test
    public void checkStartAllCars() {
        //given
        service.addCars("Van", "2");
        service.addCars("Sedan", "3");
        service.addCars("Hatchback", "1");
        service.addCars("Suv", "0");
        // when
        service.startAllCars();
        // then
        assertTrue(service.returnCars().get(0).isStarted());
        assertTrue(service.returnCars().get(1).isStarted());
        assertTrue(service.returnCars().get(2).isStarted());
        assertTrue(service.returnCars().get(3).isStarted());
    }

    @Test
    public void checkStopAllCars() {
        //given
        service.addCars("Van", "2");
        service.addCars("Sedan", "3");
        service.addCars("Hatchback", "1");
        service.addCars("Suv", "0");
        //and
        service.startAllCars();
        // when
        service.stopAllCars();
        // then
        assertFalse(service.returnCars().get(0).isStarted());
        assertFalse(service.returnCars().get(1).isStarted());
        assertFalse(service.returnCars().get(2).isStarted());
        assertFalse(service.returnCars().get(3).isStarted());
    }
}