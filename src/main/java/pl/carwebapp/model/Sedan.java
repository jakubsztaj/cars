package pl.carwebapp.model;

public class Sedan extends AbstractCar {
    public String type;

    public Sedan(String name, String type) {
        this.setName(name);
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}