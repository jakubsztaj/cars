package pl.carwebapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.Filter;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Long> {
}
