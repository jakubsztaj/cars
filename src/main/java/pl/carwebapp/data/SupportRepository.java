package pl.carwebapp.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.Support;

@Repository
public interface SupportRepository extends MongoRepository<Support, String> {
}
