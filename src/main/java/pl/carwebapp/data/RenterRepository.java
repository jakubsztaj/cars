package pl.carwebapp.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.Renter;

import java.util.Optional;

@Repository
public interface RenterRepository extends MongoRepository<Renter, String> {
    Optional<Renter> findByRenterId(String renterId);

    Optional<Renter> findByPesel(String pesel);
}
