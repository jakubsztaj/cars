package pl.carwebapp.model;

public class SportsCar extends AbstractCar {
    public SportsCar(String name, String type, int manufacturingYear, String plates, String vin, Transmission transmission, FuelType fuelType, TypeOfDrive typeOfDrive, int doors, Price price, double mpg, int seats) {
        super(type, name, manufacturingYear, Segment.S, plates, vin, transmission, fuelType, typeOfDrive, doors, price, mpg, seats);
    }
}