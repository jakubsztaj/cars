package pl.carwebapp.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.Owner;

@Repository
public interface OwnerRepository extends MongoRepository<Owner, String> {
}
