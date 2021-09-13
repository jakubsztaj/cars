package pl.carwebapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Car {
    Transmission getTransmission();

    FuelType getFuelType();

    TypeOfDrive getTypeOfDrive();

    Segment getSegment();

    Price getPrice();

    String getName();

    String getType();

    String getId();

    String getPlates();

    String getVin();

    LocalDateTime getLastRentalDate();

    LocalDateTime getBringBackDate();

    int getManufacturingYear();

    int getDoors();

    int getSeats();

    double getMpg();

    void setOwner(Owner owner);

    void setRenter(Renter renter);

    void startEngine();

    void stopEngine();

    void rentCar();

    void bringBackCar();

    void updateRentalDate(LocalDate date);

    boolean isStarted();

    boolean isRented();
}

