package pl.carwebapp.model;

public class Sedan implements Car {
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}