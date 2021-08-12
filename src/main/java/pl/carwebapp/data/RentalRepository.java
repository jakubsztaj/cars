package pl.carwebapp.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.Rental;

@Repository
public interface RentalRepository extends MongoRepository<Rental, String> {
}
