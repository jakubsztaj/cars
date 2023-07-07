package pl.carwebapp.service

import org.mockito.ArgumentCaptor
import pl.carwebapp.data.CarRepository
import pl.carwebapp.data.RentalRepository
import pl.carwebapp.data.UserRepository
import pl.carwebapp.model.Car
import pl.carwebapp.model.FuelType
import pl.carwebapp.model.Location
import pl.carwebapp.model.PaymentStatus
import pl.carwebapp.model.Rental
import pl.carwebapp.model.RentalStatus
import pl.carwebapp.model.Segment
import pl.carwebapp.model.Transmission
import pl.carwebapp.model.TypeOfDrive
import pl.carwebapp.model.User
import pl.carwebapp.util.DataGenerator
import spock.lang.Specification

import java.time.LocalDateTime

class RentalServiceSpec extends Specification {

    RentalRepository rentalRepository = Mock()

    CarRepository carRepository = Mock()

    UserRepository userRepository = Mock()

}
