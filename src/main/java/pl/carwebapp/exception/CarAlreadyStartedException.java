package pl.carwebapp.exception;

public class CarAlreadyStartedException extends RuntimeException{

    public CarAlreadyStartedException(String type, String name) {
        super("Car " + type + " with name " + name + " is already started");
    }
}
