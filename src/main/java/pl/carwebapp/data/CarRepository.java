package pl.carwebapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.AbstractCar;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<AbstractCar, Long> {
    List<AbstractCar> findByName(String name);

    List<AbstractCar> findByType(String type);

    Optional<AbstractCar> findByVin(String vin);
}

