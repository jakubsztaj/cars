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
        assertEquals(service.getCars().size(), 1);
        assertEquals(service.getCars().get(0).getType(), type);
        assertEquals(service.getCars().get(0).getName(), name + "1");
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
        assertTrue(service.getCars().get(0).isStarted());
        assertTrue(service.getCars().get(1).isStarted());
        assertTrue(service.getCars().get(2).isStarted());
        assertTrue(service.getCars().get(3).isStarted());
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
        assertFalse(service.getCars().get(0).isStarted());
        assertFalse(service.getCars().get(1).isStarted());
        assertFalse(service.getCars().get(2).isStarted());
        assertFalse(service.getCars().get(3).isStarted());
    }

    @Test
    public void tryCatch() {
        int[] something = new int[4];

        try {
            int z = something[123456];
            System.out.println("Here");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Now, Here");
        } finally {
            System.out.println("and now Here");
        }
    }
}