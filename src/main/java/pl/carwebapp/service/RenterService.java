package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import pl.carwebapp.data.RenterRepository;
import pl.carwebapp.model.Renter;
import pl.carwebapp.util.CarDataGenerator;

import java.util.List;

@Service
public class RenterService {
    private final RenterRepository repository;

    public RenterService(RenterRepository repository) {
        this.repository = repository;
    }

    public List<Renter> getAllRenters() {
        return repository.findAll();
    }

    public void addRenters(String renterName, String renterLastName) {
        repository.save(new Renter(renterName, renterLastName, CarDataGenerator.randomPersonalIdNumber()));
    }
}
