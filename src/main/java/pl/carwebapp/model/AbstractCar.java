package pl.carwebapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.carwebapp.exception.CarAlreadyStartedException;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

@Document
public abstract class AbstractCar<plates> implements Car {
    @Id
    @JsonIgnore
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public AbstractCar(String type, String name, String manufacturingYear) {
        this.type = type;
        this.name = name;
        this.manufacturingYear = manufacturingYear;
        this.plates = randomAlphabetic(3).toUpperCase() + randomNumeric(5);
        this.vin = randomNumeric(1) + randomAlphabetic(4).toUpperCase() + randomNumeric(5) + randomAlphabetic(1).toUpperCase() + randomNumeric(6);

    }

    public AbstractCar(String type, String name, String manufacturingYear, String plates, String vin) {
        this.type = type;
        this.name = name;
        this.manufacturingYear = manufacturingYear;
        this.plates = plates;
        this.vin = vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCar<?> that = (AbstractCar<?>) o;
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

    protected String manufacturingYear;

    protected String plates;

    protected String vin;

    protected LocalDateTime lastRentalDate;


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
    public void rentCar() {
        if (!rented) {
            rented = true;
            lastRentalDate = LocalDateTime.now();
        } else {
        }
    }

    @Override
    public void bringBackCar() {
        if (rented) {
            rented = false;
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
    public String getManufacturingYear() {
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

    public void setLastRentalDate(LocalDateTime lastRentalDate) {
        this.lastRentalDate = lastRentalDate;
    }
}