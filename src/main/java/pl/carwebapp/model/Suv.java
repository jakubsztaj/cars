package pl.carwebapp.model;

public class Suv extends AbstractCar {
    public String type;

    public Suv(String name, String type) {
        setName(name);
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}
