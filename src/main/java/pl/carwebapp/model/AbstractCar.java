package pl.carwebapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Document
public abstract class AbstractCar implements Car {
    @Id
    @JsonIgnore
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AbstractCar(String type, String name, int manufacturingYear, Segment segment, String plates, String vin, Transmission transmission, FuelType fuelType,
                       TypeOfDrive typeOfDrive, int doors, int price, double mpg, int seats) {
        this.type = type;
        this.name = name;
        this.manufacturingYear = manufacturingYear;
        this.plates = plates;
        this.vin = vin;
        this.segment = segment;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.typeOfDrive = typeOfDrive;
        this.doors = doors;
        this.price = price;
        this.mpg = mpg;
        this.seats = seats;
    }

    protected String type; //e

    protected String name; //e

    protected int manufacturingYear;

    protected String plates;

    protected String vin;

    protected Transmission transmission;

    protected FuelType fuelType;

    protected TypeOfDrive typeOfDrive;

    protected int price;

    protected LocalDateTime lastRentalDate;

    protected Segment segment;

    protected LocalDateTime bringBackDate;

    protected LocalDate lastServiceDate;

    protected Owner owner;

    protected Renter renter;

    protected int doors;

    protected int seats;

    protected double mpg;

    boolean rented = false;
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
        }
    }

    @Override
    public void rentCar() {
        if (!rented) {
            rented = true;
            lastRentalDate = LocalDateTime.now();
            bringBackDate = null;
        }
    }

    @Override
    public void bringBackCar() {
        if (rented) {
            rented = false;
            bringBackDate = LocalDateTime.now();
            started = false;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCar that = (AbstractCar) o;
        return getVin().equals(that.getVin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVin());
    }

    @Override
    public boolean isRented() {
        return rented;
    }

    @Override
    public boolean isStarted() {
        return started;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getManufacturingYear() {
        return manufacturingYear;
    }

    @Override
    public String getPlates() {
        return plates;
    }

    @Override
    public String getVin() {
        return vin;
    }

    @Override
    public LocalDateTime getLastRentalDate() {
        return lastRentalDate;
    }

    @Override
    public Segment getSegment() {
        return segment;
    }

    @Override
    public LocalDateTime getBringBackDate() {
        return bringBackDate;
    }

    @Override
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    @Override
    public void updateRentalDate(LocalDate date) {
        this.lastServiceDate = date;
    }

    @Override
    public Transmission getTransmission() {
        return transmission;
    }

    @Override
    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public TypeOfDrive getTypeOfDrive() {
        return typeOfDrive;
    }

    @Override
    public int getDoors() {
        return doors;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public double getMpg() {
        return mpg;
    }

    @Override
    public int getSeats() {
        return seats;
    }
}