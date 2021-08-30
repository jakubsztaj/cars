package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import pl.carwebapp.data.CarRepository;
import pl.carwebapp.data.RentalRepository;
import pl.carwebapp.data.RenterRepository;
import pl.carwebapp.model.Car;
import pl.carwebapp.model.Rental;
import pl.carwebapp.model.Renter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentalService {
    private final CarRepository carRepository;

    private final RenterRepository renterRepository;

    private final RentalRepository rentalRepository;

    public RentalService(CarRepository carRepository, RenterRepository renterRepository, RentalRepository rentalRepository) {
        this.carRepository = carRepository;
        this.renterRepository = renterRepository;
        this.rentalRepository = rentalRepository;
    }

    public void createRental(String renterId, String vin, LocalDateTime rentalBegin, LocalDateTime rentalEnd, BigDecimal pricePerDay) {
        Car car = carRepository.findByVin(vin).get();
        Renter renter = renterRepository.findByRenterId(renterId).get();

        var rental = new Rental();
        rental.setRenter(renter);
        rental.setCar(car);
        rental.setRentalBegin(rentalBegin);
        rental.setRentalEnd(rentalEnd);
        rental.setPricePerDay(pricePerDay);

        rentalRepository.save(rental);
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public void deleteRentals() {
        rentalRepository.deleteAll();
    }

    public long countRentals() {
        return rentalRepository.count();
    }
}
