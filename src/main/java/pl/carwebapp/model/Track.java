package pl.carwebapp.model;

public class Track extends AbstractCar {

    public Track(String name, String type, int manufacturingYear, String segment, String plates, String vin, String transmission, String fuelType, String typeOfDrive) {
        super(type, name, manufacturingYear, segment, plates, vin, transmission, fuelType, typeOfDrive);
    }
}
