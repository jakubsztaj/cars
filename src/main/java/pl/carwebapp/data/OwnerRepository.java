package pl.carwebapp.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.carwebapp.model.Owner;

public interface OwnerRepository extends MongoRepository<Owner, String> {
}
