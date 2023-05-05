package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import pl.carwebapp.data.CarRepository;
import pl.carwebapp.data.RentalRepository;
import pl.carwebapp.data.UserRepository;
import pl.carwebapp.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static pl.carwebapp.model.PaymentStatus.DEFICIENCY;
import static pl.carwebapp.model.RentalStatus.ACTIVE;

@Service
public class RentalService {
    private final CarRepository carRepository;

    private final UserRepository userRepository;

    private final RentalRepository rentalRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public List<Rental> getActiveRentals() {
        return rentalRepository.findAllByRentalStatus(ACTIVE);
    }

    public List<Rental> getClearRentals() {
        return rentalRepository.findAllByPaymentStatus(DEFICIENCY);
    }


    public RentalService(CarRepository carRepository, UserRepository userRepository, RentalRepository rentalRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.rentalRepository = rentalRepository;
    }

    public void createRental(String pesel, String vin, LocalDateTime rentalBegin, LocalDateTime rentalEnd, BigDecimal deposit, Location location) {
        Car car = carRepository.findByVin(vin).get();
        User user = userRepository.findByPesel(pesel).get();

        var rental = new Rental();
        rental.setRenter(user);
        rental.setCar(car);
        rental.setRentalBegin(rentalBegin);
        rental.setRentalEnd(rentalEnd);
        rental.setDeposit(deposit);
        rental.setLocation(location);
        rental.setRentalStatus(ACTIVE);
        rental.setPaymentStatus(DEFICIENCY);

        rentalRepository.save(rental);
    }


    public void deleteRental() {
    }

    public void deleteRentals() {
        rentalRepository.deleteAll();
    }

    public void changeStatus(String vin) {
        rentalRepository.findByCarVin(vin).ifPresent(rental -> {
            rental.markPaymentCompleted();
            rentalRepository.save(rental);
        });

    }

    public List<Rental> filterByStatus(PaymentStatus paymentStatus) {
        return rentalRepository.findAllByPaymentStatus(paymentStatus);
    }

    public int countRentals() {
        return (int) rentalRepository.count();
    }
}
