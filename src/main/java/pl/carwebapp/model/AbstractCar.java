package pl.carwebapp.model;

public abstract class AbstractCar implements Car {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
