package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import pl.carwebapp.data.UserRepository;
import pl.carwebapp.model.User;
import pl.carwebapp.util.DataGenerator;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllRenters() {
        return repository.findAll();
    }

    public User getRenterByPesel(String pesel) {
        return repository.findByPesel(pesel).orElseThrow(IllegalStateException::new);
    }

    public void addRenters(String renterName, String renterLastName, String renterPlaceOfResidence, String renterLogin, String renterPassword) {
        repository.save(new User(renterName, renterLastName, renterPlaceOfResidence, DataGenerator.randomPersonalIdNumber(),
                DataGenerator.randomPhoneNumber(), renterLogin, renterPassword));
    }

    public void deleteRenter(String pesel) {
        repository.findByPesel(pesel).ifPresent(renter -> {
            if (renter.getPesel().equalsIgnoreCase(pesel)) {
                repository.delete(renter);
            }
        });
    }

    public void deleteRenters() {
        repository.deleteAll();
    }

    public List<User> byPesel(String pesel) {
        return repository.findAll().stream()
                .filter(renter -> renter.getPesel().toLowerCase(Locale.ROOT).startsWith(pesel.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    public List<User> byLastName(String lastName) {
        return repository.findAll().stream()
                .filter(renter -> renter.getLastName().toLowerCase(Locale.ROOT).startsWith(lastName.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    public List<User> byPlaceOfResidence(String placeOfResidence) {
        return repository.findAll().stream()
                .filter(renter -> renter.getPlaceOfResidence().toLowerCase(Locale.ROOT).startsWith(placeOfResidence.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    public int countRenters() {
        return (int) repository.count();
    }
}
