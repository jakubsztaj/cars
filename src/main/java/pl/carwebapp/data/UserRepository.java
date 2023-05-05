package pl.carwebapp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByRenterId(String renterId);

    Optional<User> findByPesel(String pesel);

    Optional<User> findByLastName(String lastName);

    Optional<User> findByPlaceOfResidence(String placeOfResidence);
}
