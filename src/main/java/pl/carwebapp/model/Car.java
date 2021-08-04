package pl.carwebapp.model;

import java.time.LocalDateTime;

public interface Car {
    String getName();

    String getType();

    String getId();

    String getPlates();

    String getVin();

    String getCategory();

    LocalDateTime getLastRentalDate();

    LocalDateTime getBringBackDate();


    int getManufacturingYear();

    void setOwner(Owner owner);

    void startEngine();

    void stopEngine();

    void rentCar();

    void bringBackCar();

    boolean isStarted();

    boolean isRented();
}

