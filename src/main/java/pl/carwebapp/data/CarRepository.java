package pl.carwebapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByName(String name);

    List<Car> findByType(String type);

    Optional<Car> findByVin(String vin);
}

