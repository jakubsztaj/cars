package pl.carwebapp.model;

public class Van extends AbstractCar {
    public Van(String name, String type, int manufacturingYear, String plates, String vin, Transmission transmission, FuelType fuelType,
               TypeOfDrive typeOfDrive, int doors, int price, double mpg, int seats) {
        super(type, name, manufacturingYear, Segment.M, plates, vin, transmission, fuelType, typeOfDrive, doors, price, mpg, seats);
    }
}
