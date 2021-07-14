package pl.carwebapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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


    public AbstractCar(String type, String name, int manufacturingYear, String category, String plates, String vin) {
        this.type = type;
        this.name = name;
        this.manufacturingYear = manufacturingYear;
        this.plates = plates;
        this.vin = vin;
        this.category = category;
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

    boolean rented = false;
    boolean started = false;

    protected String type;

    protected String name;

    protected int manufacturingYear;

    protected String plates;

    protected String vin;

    protected LocalDateTime lastRentalDate;

    protected String category;

    protected LocalDateTime bringBackDate;

    protected Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

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
        }
    }

    @Override
    public void bringBackCar() {
        if (rented) {
            rented = false;
            bringBackDate = LocalDateTime.now();
        }
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
    public String getCategory() {
        return category;
    }

    @Override
    public LocalDateTime getBringBackDate() {
        return bringBackDate;
    }

}