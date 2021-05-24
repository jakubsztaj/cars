package pl.carwebapp.model;

public abstract class AbstractCar implements Car {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    boolean started = false;

    @Override
    public boolean isStarted() {
        return started;
    }

    public void startEngine() {
        if (!started) {
            started = true;
        } else {
            // odpalony silnik nie odpale drugi raz
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

}
