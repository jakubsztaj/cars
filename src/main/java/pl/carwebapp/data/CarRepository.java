package pl.carwebapp.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    List<Car> findByName(String name);

    Optional<Car> findByVin(String vin);
}

