package pl.carwebapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Car {
    String getName();

    String getType();

    String getId();

    String getPlates();

    String getVin();

    String getSegment();

    String getTransmission();

    String getFuelType();

    String getTypeOfDrive();

    LocalDateTime getLastRentalDate();

    LocalDateTime getBringBackDate();

    int getManufacturingYear();

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

