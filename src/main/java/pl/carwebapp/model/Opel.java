package pl.carwebapp.model;

public class Opel extends AbstractCar {

    public String type;

    public Opel(String name, String type) {
        this.setName(name);
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}
