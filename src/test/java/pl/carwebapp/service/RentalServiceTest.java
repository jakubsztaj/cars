package pl.carwebapp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.carwebapp.data.CarRepository;
import pl.carwebapp.data.RentalRepository;
import pl.carwebapp.data.UserRepository;
import pl.carwebapp.model.*;
import pl.carwebapp.util.DataGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RentalServiceTest {
    @Mock
    private RentalRepository rentalRepository;
    @Mock
    private CarRepository carRepository;
    @Mock
    private UserRepository userRepository;
    @Test
    void createRental_shouldAddNewRental() throws Exception {
        //given
        RentalService rentalService = new RentalService(carRepository, userRepository, rentalRepository);

        ArgumentCaptor<Rental> captor = ArgumentCaptor.forClass(Rental.class);

        String vin = "123ABC";

        String pesel = "12345678901234";

        Car testCar = new Car("hatchback", "Opel Astra", 2005, Segment.C, DataGenerator.randomPlatesNumber(), vin,
                Transmission.MANUAL, FuelType.PETROL, TypeOfDrive.FWD, 5, 150, 6.0, 5);

        User testUser = new User("Jakub", "Kowalski", "Wroclaw",
                pesel, DataGenerator.randomPhoneNumber(), "test", "test");

        when(carRepository.findByVin(vin)).thenReturn(Optional.of(testCar));

        when(userRepository.findByPesel(pesel)).thenReturn(Optional.of(testUser));

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now().plusDays(3);
        BigDecimal deposit = BigDecimal.valueOf(500);
        Location location = Location.BELCHATOW;

        //when
        rentalService.createRental(pesel,vin,currentTime,endTime,deposit,location);

        //then
        verify(carRepository, times(1)).findByVin(vin);
        verify(userRepository, times(1)).findByPesel(pesel);

        verify(rentalRepository, times(1)).save(captor.capture());
        Rental captuedRental = captor.getValue();
        assertEquals(testCar, captuedRental.getCar());
        assertEquals(testUser, captuedRental.getRenter());
        assertEquals(currentTime, captuedRental.getRentalBegin());
        assertEquals(endTime, captuedRental.getRentalEnd());
        assertEquals(deposit, captuedRental.getDeposit());
        assertEquals(RentalStatus.ACTIVE, captuedRental.getRentalStatus());
        assertEquals(PaymentStatus.DEFICIENCY, captuedRental.getPaymentStatus());

    }
    @Test
    void getAllRentals() {
    }

    @Test
    void getActiveRentals() {
    }

    @Test
    void getClearRentals() {
    }

    @Test
    void deleteRental() {
    }

    @Test
    void deleteRentals() {
    }

    @Test
    void changeStatus() {
    }

    @Test
    void filterByStatus() {
    }

    @Test
    void countRentals() {
    }
}
