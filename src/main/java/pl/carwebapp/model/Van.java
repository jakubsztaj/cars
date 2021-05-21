package pl.carwebapp.model;

public class Van extends AbstractCar {
    public String type ;
    public Van(String name, String type) {
        setName(name);
        this.type = type;
    }
}
