package pl.carwebapp.model;

public class Sedan extends AbstractCar {

    public Sedan(String name, String type, int manufacturingYear, String category, String plates, String vin) {
        super(type, name, manufacturingYear, category, plates, vin);
    }
}