package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import pl.carwebapp.data.CarRepository;
import pl.carwebapp.data.FilterRepository;
import pl.carwebapp.data.RentalRepository;
import pl.carwebapp.model.Car;
import pl.carwebapp.model.PaymentStatus;
import pl.carwebapp.model.Rental;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class FilterService {

    private final FilterRepository filterRepository;

    private final CarRepository repository;

    private final RentalRepository rentalRepository;

    public FilterService(FilterRepository filterRepository, CarRepository repository, RentalRepository rentalRepository) {
        this.filterRepository = filterRepository;
        this.repository = repository;
        this.rentalRepository = rentalRepository;
    }

    public List<Car> filterByType(String type) {
        return repository.findAll().stream()
                .filter(car -> car.getType().toLowerCase(Locale.ROOT).startsWith(type))
                .collect(Collectors.toList());
    }

    public List<Car> byVin(String vin) {
        return repository.findAll().stream()
                .filter(car -> car.getVin().toLowerCase(Locale.ROOT).startsWith(vin.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    public List<Car> filterByName(String name) {
        return repository.findAll().stream()
                .filter(car -> car.getName().toLowerCase(Locale.ROOT).startsWith(name))
                .collect(Collectors.toList());
    }

    public List<Rental> filterByStatus(PaymentStatus paymentStatus) {
        return rentalRepository.findAllByPaymentStatus(paymentStatus);
    }



}
