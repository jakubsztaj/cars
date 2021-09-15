package pl.carwebapp.service;

import org.springframework.stereotype.Service;
import pl.carwebapp.data.OwnerRepository;
import pl.carwebapp.model.Owner;
import pl.carwebapp.util.CarDataGenerator;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository repository;

    public OwnerService(OwnerRepository repository) {
        this.repository = repository;
    }

    public List<Owner> getAllOwners() {
        return repository.findAll();
    }

    public void addOwners(String ownerName, String ownerLastName) {
        repository.save(new Owner(ownerName, ownerLastName, CarDataGenerator.randomPersonalIdNumber()));
    }

    public void deleteOwners() {
        repository.deleteAll();
    }

}
