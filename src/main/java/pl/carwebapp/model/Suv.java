package pl.carwebapp.model;

public class Suv extends AbstractCar {

    public Suv(String name, String type, int manufacturingYear, String segment, String plates, String vin, String transimission, String fuelType, String typeOfDrive) {
        super(type, name, manufacturingYear, segment, plates, vin, transimission, fuelType, typeOfDrive);
    }
}
