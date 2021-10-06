package pl.carwebapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Car {
    Transmission getTransmission();

    FuelType getFuelType();

    TypeOfDrive getTypeOfDrive();

    Segment getSegment();

    CarStatus getCarStatus();

    String getName();

    String getType();

    String getId();

    String getPlates();

    String getVin();

    LocalDateTime getLastRentalDate();

    LocalDateTime getBringBackDate();

    BigDecimal getPrice();

    int getManufacturingYear();

    int getDoors();

    int getSeats();

    void setRenter(Renter renter);

    void rentCar();

    void bringBackCar();

    void updateRentalDate(LocalDate date);

    void setCarStatus(CarStatus carStatus);

    boolean isRented();

    double getMpg();

}

