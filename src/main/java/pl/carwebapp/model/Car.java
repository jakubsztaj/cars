package pl.carwebapp.model;

import java.time.LocalDateTime;

public interface Car {
    String getName();

    String getType();

    String getId();

    int getManufacturingYear();

    String getPlates();

    String getVin();

    String getCategory();

    LocalDateTime getLastRentalDate();

    LocalDateTime getBringBackDate();

    void setOwner(Owner owner);

    void startEngine();

    void stopEngine();

    boolean isStarted();

    void rentCar();

    void bringBackCar();

    boolean isRented();
}

