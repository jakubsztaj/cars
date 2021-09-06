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

    public AbstractCar(String type, String name, int manufacturingYear, String segment, String plates, String vin, String transmission, String fuelType, String typeOfDrive) {
        this.type = type;
        this.name = name;
        this.manufacturingYear = manufacturingYear;
        this.plates = plates;
        this.vin = vin;
        this.segment = segment;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.typeOfDrive = typeOfDrive;
    }

    protected String type;

    protected String name;

    protected int manufacturingYear;

    protected String plates;

    protected String vin;

    protected String transmission;

    protected String fuelType;

    protected String typeOfDrive;

    protected LocalDateTime lastRentalDate;

    protected String segment;

    protected LocalDateTime bringBackDate;

    protected LocalDate lastServiceDate;

    protected Owner owner;

    protected Renter renter;

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
    public String getSegment() {
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
    public String getTransmission() {
        return transmission;
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }

    @Override
    public String getTypeOfDrive() {
        return typeOfDrive;
    }
}