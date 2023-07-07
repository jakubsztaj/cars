package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> getAllRenters() {
        return repository.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User getRenterByPesel(String pesel) {
        return repository.findByPesel(pesel).orElseThrow(IllegalStateException::new);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRenters(String renterName, String renterLastName, String renterPlaceOfResidence, String renterLogin, String renterPassword) {
        repository.save(new User(renterName, renterLastName, renterPlaceOfResidence, DataGenerator.randomPersonalIdNumber(),
                DataGenerator.randomPhoneNumber(), renterLogin, renterPassword));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(String pesel) {
        repository.findByPesel(pesel).ifPresent(user -> {
            if (user.getPesel().equalsIgnoreCase(pesel)) {
                repository.delete(user);
            }
        });
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteRenters() {
        repository.deleteAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> byPesel(String pesel) {
        return repository.findAll().stream()
                .filter(renter -> renter.getPesel().toLowerCase(Locale.ROOT).startsWith(pesel.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> byLastName(String lastName) {
        return repository.findAll().stream()
                .filter(renter -> renter.getLastName().toLowerCase(Locale.ROOT).startsWith(lastName.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> byPlaceOfResidence(String placeOfResidence) {
        return repository.findAll().stream()
                .filter(renter -> renter.getPlaceOfResidence().toLowerCase(Locale.ROOT).startsWith(placeOfResidence.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int countRenters() {
        return (int) repository.count();
    }
}
