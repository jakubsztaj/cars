package pl.carwebapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static pl.carwebapp.model.PaymentStatus.DEFICIENCY;
import static pl.carwebapp.model.RentalStatus.ACTIVE;

@Document
public class Rental {

    @Id
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Renter renter;

    private Car car;

    LocalDateTime rentalBegin;

    LocalDateTime rentalEnd;

    BigDecimal pricePerDay;

    BigDecimal deposit;

    BigDecimal totalPayment;

    BigDecimal currentBalance;

    Location location;

    RentalStatus rentalStatus;

    PaymentStatus paymentStatus;

    public Rental() {
    }

    public Rental(Renter renter, Car car, LocalDateTime rentalBegin, LocalDateTime rentalEnd, BigDecimal deposit, Location location) {
        this.renter = renter;
        this.car = car;
        this.rentalBegin = rentalBegin;
        this.rentalEnd = rentalEnd;
        this.deposit = deposit;
        this.location = location;
        this.setRentalStatus(ACTIVE);
        this.setPaymentStatus(DEFICIENCY);
        this.setTotalPayment(deposit.add(car.getPrice()));
        this.currentBalance = BigDecimal.ZERO;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public RentalStatus getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(RentalStatus rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

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

    public boolean expiringInOneDay() {
        return rentalEnd.toLocalDate().minusDays(1).equals(LocalDate.now());
    }

    public void markPaymentCompleted() {
        this.paymentStatus = PaymentStatus.COMPLETED;
    }

    public void addPayment(BigDecimal amount) {
        this.currentBalance = this.currentBalance.add(amount);
        if (currentBalance.compareTo(this.totalPayment) >= 0) {
            this.paymentStatus = PaymentStatus.COMPLETED;
        } else {
            this.paymentStatus = PaymentStatus.PROGRESSING;
        }
    }
}

