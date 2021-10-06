package pl.carwebapp.model;

import java.math.BigDecimal;

public class Track extends AbstractCar {

    public Track(String name, String type, int manufacturingYear, String plates, String vin, Transmission transmission, FuelType fuelType,
                 TypeOfDrive typeOfDrive, int doors, BigDecimal price, double mpg, int seats) {
        super(type, name, manufacturingYear, Segment.A, plates, vin, transmission, fuelType, typeOfDrive, doors, price, mpg, seats);
    }
}
