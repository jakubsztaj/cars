package pl.carwebapp.model;

import java.math.BigDecimal;

public class Suv extends AbstractCar {

    public Suv(String name, String type, int manufacturingYear, String plates, String vin, Transmission transmission, FuelType fuelType,
               TypeOfDrive typeOfDrive, int doors, BigDecimal price, double mpg, int seats) {
        super(type, name, manufacturingYear, Segment.J, plates, vin, transmission, fuelType, typeOfDrive, doors, price, mpg, seats);
    }
}
