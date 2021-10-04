package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import pl.carwebapp.data.RenterRepository;
import pl.carwebapp.model.Renter;
import pl.carwebapp.util.CarDataGenerator;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class RenterService {
    private final RenterRepository repository;

    public RenterService(RenterRepository repository) {
        this.repository = repository;
    }

    public List<Renter> getAllRenters() {
        return repository.findAll();
    }

    public void addRenters(String renterName, String renterLastName, String renterPlaceOfResidence) {
        repository.save(new Renter(renterName, renterLastName, renterPlaceOfResidence, CarDataGenerator.randomPersonalIdNumber(), CarDataGenerator.randomPhoneNumber()));
    }

    public void deleteRenters() {
        repository.deleteAll();
    }

    public void deleteRenter(String pesel) {
        repository.findByPesel(pesel).ifPresent(renter -> {
            if (renter.getPesel().equalsIgnoreCase(pesel)) {
                repository.delete(renter);
            }
        });
    }

    public List<Renter> byPesel(String pesel) {
        return repository.findAll().stream()
                .filter(renter -> renter.getPesel().toLowerCase(Locale.ROOT).startsWith(pesel.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    public int countRenters() {
        return (int) repository.count();
    }
}
