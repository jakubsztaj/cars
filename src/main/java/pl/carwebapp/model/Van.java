package pl.carwebapp.model;

public class Van extends AbstractCar {

    public Van(String name, String type, int manufacturingYear, String category, String plates, String vin) {
        super(type, name, manufacturingYear, category, plates, vin);
    }
}
