package pl.carwebapp.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.Filter;

@Repository
public interface FilterRepository extends MongoRepository<Filter, String> {
}
