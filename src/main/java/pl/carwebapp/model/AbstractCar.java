package pl.carwebapp.model;

public abstract class AbstractCar implements Car {
    protected String type;

    protected String name;

    public AbstractCar(String type, String name) {
        this.type = type;
        this.name = name;
    }

    boolean started = false;

    public void startEngine() {
        if (!started) {
            started = true;
        } else {
        }
    }

    @Override
    public void stopEngine() {
        if (started) {
            started = false;
        } else {
            throw new RuntimeException();
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