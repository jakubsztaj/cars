package pl.carwebapp.model;

public class Suv extends AbstractCar {

    public Suv(String name, String type, int manufacturingYear, String category, String plates, String vin) {
        super(type, name, manufacturingYear, category, plates, vin);
    }
}
