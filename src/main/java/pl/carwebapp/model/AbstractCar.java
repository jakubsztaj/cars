package pl.carwebapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import static pl.carwebapp.model.CarStatus.AVAILABLE;
import static pl.carwebapp.model.CarStatus.RENTED;

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
        this.carStatus = AVAILABLE;
    }

    protected String type;

    protected String name;

    protected String plates;

    protected String vin;

    protected Transmission transmission;

    protected FuelType fuelType;

    protected TypeOfDrive typeOfDrive;

    protected CarStatus carStatus;

    protected Renter renter;

    protected Segment segment;

    protected LocalDateTime lastRentalDate;

    protected LocalDateTime bringBackDate;

    protected LocalDate lastServiceDate;

    protected int price;

    protected int doors;

    protected int seats;

    protected int manufacturingYear;

    protected double mpg;

    @Override
    public void rentCar() {
        if (carStatus == AVAILABLE) {
            carStatus = RENTED;
            lastRentalDate = LocalDateTime.now();
            bringBackDate = null;
        }
    }

    @Override
    public void bringBackCar() {
        if (isRented()) {
            carStatus = AVAILABLE;
            bringBackDate = LocalDateTime.now();
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
        return carStatus == RENTED;
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

    @Override
    public CarStatus getCarStatus() {
        return carStatus;
    }

    @Override
    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }
}