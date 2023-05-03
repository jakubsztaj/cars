package pl.carwebapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import static pl.carwebapp.model.CarStatus.AVAILABLE;
import static pl.carwebapp.model.CarStatus.RENTED;

@Entity
@Table(name = "samochod")
public abstract class AbstractCar implements Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_samochodu")
    private Long carId;

    public AbstractCar() {
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
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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
