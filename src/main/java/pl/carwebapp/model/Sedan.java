package pl.carwebapp.model;

public class Sedan extends AbstractCar {

    public Sedan(String name, String type, int manufacturingYear, String segment, String plates, String vin, String transmission, String fuelType, String typeOfDrive) {
        super(type, name, manufacturingYear, segment, plates, vin, transmission, fuelType, typeOfDrive);
    }
}