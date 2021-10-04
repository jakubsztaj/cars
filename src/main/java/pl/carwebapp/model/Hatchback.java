package pl.carwebapp.model;

public class Hatchback extends AbstractCar {

    public Hatchback(String name, String type, int manufacturingYear, String plates, String vin, Transmission transmission, FuelType fuelType,
                     TypeOfDrive typeOfDrive, int doors, int price, double mpg, int seats) {
        super(type, name, manufacturingYear, Segment.C, plates, vin, transmission, fuelType, typeOfDrive, doors, price, mpg, seats);
    }
}
