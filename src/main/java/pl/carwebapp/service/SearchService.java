package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import pl.carwebapp.data.CarRepository;
import pl.carwebapp.data.RentalRepository;
import pl.carwebapp.data.RenterRepository;
import pl.carwebapp.model.Car;
import pl.carwebapp.model.Rental;
import pl.carwebapp.model.Renter;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final CarRepository carRepository;

    private final RenterRepository renterRepository;

    private final RentalRepository rentalRepository;


    public SearchService(CarRepository carRepository, RenterRepository renterRepository, RentalRepository rentalRepository) {
        this.carRepository = carRepository;
        this.renterRepository = renterRepository;
        this.rentalRepository = rentalRepository;
    }

    private boolean carPredicate(Car car, String phrase) {
        return car.getType().toLowerCase().contains(phrase) ||
                car.getName().toLowerCase().contains(phrase) ||
                car.getPlates().toLowerCase().contains(phrase);
    }

    private boolean renterPredicate(Renter renter, String phrase) {
        return renter.getFirstName().toLowerCase().contains(phrase) ||
                renter.getLastName().toLowerCase().contains(phrase);
    }

    private boolean rentalPredicate(Rental rental, String phrase) {
        String lowerCasePhrase = phrase.toLowerCase();
        return carPredicate(rental.getCar(), lowerCasePhrase) || renterPredicate(rental.getRenter(), lowerCasePhrase);
    }

    public List<Rental> searchRentalByPhrase(String phrase) {
        return rentalRepository.findAll().stream()
                .filter(rental ->rentalPredicate(rental, phrase))
                .collect(Collectors.toList());
    }
    public List<Renter> searchRenterByPhrase(String phrase) {
        return renterRepository.findAll().stream()
                .filter(renter ->renterPredicate(renter, phrase))
                .collect(Collectors.toList());
    }
    public List<Car> searchCarByPhrase(String phrase) {
        return carRepository.findAll().stream()
                .filter(car ->carPredicate(car, phrase))
                .collect(Collectors.toList());
    }
}
