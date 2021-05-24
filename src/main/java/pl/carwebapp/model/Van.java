package pl.carwebapp.model;

public class Van extends AbstractCar {
    public String type;

    public Van(String name, String type) {
        this.setName(name);
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}
