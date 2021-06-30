package pl.carwebapp.model;

import java.time.LocalDateTime;

public interface Car {
    String getName();

    String getType();

    String getId();

    String getManufacturingYear();

    String getPlates();

    String getVin();

    LocalDateTime getLastRentalDate();

    void startEngine();

    void stopEngine();

    boolean isStarted();

    void rentCar();

    void bringBackCar();

    boolean isRented();

}

