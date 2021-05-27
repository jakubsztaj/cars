package pl.carwebapp.model;

import pl.carwebapp.exception.CarAlreadyStartedException;

public abstract class AbstractCar implements Car {
    boolean started = false;

    public AbstractCar() {
    }

    protected String type;

    protected String name;

    public AbstractCar(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public void startEngine() {
        if (!started) {
            started = true;
        } else {
            throw new CarAlreadyStartedException(type, name);
        }
    }

    @Override
    public void stopEngine() {
        if (started) {
            started = false;
        } else {
        }

    }

    @Override
    public boolean isStarted() {
        return started;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return type;
    }
}