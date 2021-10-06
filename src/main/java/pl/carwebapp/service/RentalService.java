package pl.carwebapp.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.carwebapp.data.CarRepository;
import pl.carwebapp.data.RentalRepository;
import pl.carwebapp.data.RenterRepository;
import pl.carwebapp.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static pl.carwebapp.model.PaymentStatus.DEFICIENCY;
import static pl.carwebapp.model.RentalStatus.ACTIVE;

@Service
public class RentalService {
    private final CarRepository carRepository;

    private final RenterRepository renterRepository;

    private final RentalRepository rentalRepository;

    private final SupportService service;

    public RentalService(CarRepository carRepository, RenterRepository renterRepository, RentalRepository rentalRepository, SupportService service) {
        this.carRepository = carRepository;
        this.renterRepository = renterRepository;
        this.rentalRepository = rentalRepository;
        this.service = service;
    }

    public void createRental(String pesel, String vin, LocalDateTime rentalBegin, LocalDateTime rentalEnd, BigDecimal deposit, Location location) {
        Car car = carRepository.findByVin(vin).get();
        Renter renter = renterRepository.findByPesel(pesel).get();

        var rental = new Rental(renter, car, rentalBegin, rentalEnd, deposit, location);
        car.rentCar();

        rentalRepository.save(rental);
        carRepository.save(car);
        notifyAboutCarLocation(rental);
    }


    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public List<Rental> getActiveRentals() {
        return rentalRepository.findAllByRentalStatus(ACTIVE);
    }

    public List<Rental> getClearRentals() {
        return rentalRepository.findAllByPaymentStatus(DEFICIENCY);
    }

    public void deleteRentals() {
        rentalRepository.deleteAll();
    }

    public int countRentals() {
        return (int) rentalRepository.count();
    }

    public void notifyAboutCarLocation(Rental rental) {
        service.sendRentalNotification(rental);
    }

    @Scheduled(fixedDelay = 3000)
    public void createReminder() {
        rentalRepository.findAll()
                .stream()
                .filter(Rental::expiringInOneDay)
                .forEach(this.service::sendRentalReminder);
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

    public void payForRental(String rentalId, BigDecimal amount) {
        rentalRepository.findById(rentalId).ifPresent(rental -> {
            rental.addPayment(amount);
            rentalRepository.save(rental);
        });
    }

}
