package pl.carwebapp.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.Stats;

@Repository
public interface StatisticsRepository extends MongoRepository<Stats, String> {
}
