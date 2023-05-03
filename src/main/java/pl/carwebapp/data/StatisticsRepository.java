package pl.carwebapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.Stats;

@Repository
public interface StatisticsRepository extends JpaRepository<Stats, Long> {
}
