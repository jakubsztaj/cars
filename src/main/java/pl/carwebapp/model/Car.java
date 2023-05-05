package pl.carwebapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import static pl.carwebapp.model.CarStatus.AVAILABLE;
import static pl.carwebapp.model.CarStatus.RENTED;

@Entity
@Table(name = "samochod")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_samochodu")
    private Long carId;

    public Car() {
    }

    public Car(String type, String name, int manufacturingYear, Segment segment, String plates, String vin, Transmission transmission, FuelType fuelType,
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

    @Column(name = "typ")
    protected String type;

    @Column(name = "nazwa")
    protected String name;
    @Column(name = "tablice")
    protected String plates;

    @Column(name = "vin")
    protected String vin;

    @Column(name = "skrzynia_biegow")
    @Enumerated(EnumType.STRING)
    protected Transmission transmission;

    @Column(name = "typ_paliwa")
    @Enumerated(EnumType.STRING)
    protected FuelType fuelType;

    @Column(name = "typ_napedu")
    @Enumerated(EnumType.STRING)
    protected TypeOfDrive typeOfDrive;
    @Column(name = "status_dostepnosci")
    @Enumerated(EnumType.STRING)
    protected CarStatus carStatus;

    @Column(name = "segment")
    @Enumerated(EnumType.STRING)
    protected Segment segment;
    @Column(name = "data_ostatniego_wypozyczenia")
    protected LocalDateTime lastRentalDate;
    @Column(name = "data_sprowadzenia_samochodu")
    protected LocalDateTime bringBackDate;
    @Column(name = "data_serwisu")
    protected LocalDate lastServiceDate;

    @Column(name = "cena")
    protected int price;
    @Column(name = "liczba_drzwi")
    protected int doors;
    @Column(name = "liczba_siedzen")
    protected int seats;

    @Column(name = "rok_produkcji")
    protected int manufacturingYear;

    @Column(name = "spalanie")
    protected double mpg;

    public void rentCar() {
        if (carStatus == AVAILABLE) {
            carStatus = RENTED;
            lastRentalDate = LocalDateTime.now();
            bringBackDate = null;
        }
    }

    public void bringBackCar() {
        if (isRented()) {
            carStatus = AVAILABLE;
            bringBackDate = LocalDateTime.now();
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car that = (Car) o;
        return getVin().equals(that.getVin());
    }

    public int hashCode() {
        return Objects.hash(getVin());
    }

    public boolean isRented() {
        return carStatus == RENTED;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return type;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public String getPlates() {
        return plates;
    }

    public String getVin() {
        return vin;
    }

    public LocalDateTime getLastRentalDate() {
        return lastRentalDate;
    }

    public Segment getSegment() {
        return segment;
    }

    public LocalDateTime getBringBackDate() {
        return bringBackDate;
    }

    public void updateRentalDate(LocalDate date) {
        this.lastServiceDate = date;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public TypeOfDrive getTypeOfDrive() {
        return typeOfDrive;
    }

    public int getDoors() {
        return doors;
    }

    public int getPrice() {
        return price;
    }

    public double getMpg() {
        return mpg;
    }

    public int getSeats() {
        return seats;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }
}
