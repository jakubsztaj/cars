package pl.carwebapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document
public class Rental {

    private Renter renter;

    private Car car;

    LocalDateTime rentalBegin;

    LocalDateTime rentalEnd;

    BigDecimal pricePerDay;

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getRentalBegin() {
        return rentalBegin;
    }

    public void setRentalBegin(LocalDateTime rentalBegin) {
        this.rentalBegin = rentalBegin;
    }

    public LocalDateTime getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd(LocalDateTime rentalEnd) {
        this.rentalEnd = rentalEnd;
    }

    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

}
