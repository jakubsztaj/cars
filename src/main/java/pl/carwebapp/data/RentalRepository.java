package pl.carwebapp.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.carwebapp.model.PaymentStatus;
import pl.carwebapp.model.Rental;
import pl.carwebapp.model.RentalStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalRepository extends MongoRepository<Rental, String> {
    List<Rental> findAllByRentalStatus(RentalStatus status);

    List<Rental> findAllByPaymentStatus(PaymentStatus paymentStatus);

    Optional<Rental> findByCarVin(String vin);
}
