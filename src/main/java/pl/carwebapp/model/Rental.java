package pl.carwebapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    public Rental() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    private Renter renter;

    @OneToOne
    private AbstractCar car;

    @OneToOne
    private StaffMember staffMember;

    @OneToMany
    private List<Payment> payment;

    LocalDateTime rentalBegin;

    LocalDateTime rentalEnd;

    BigDecimal pricePerDay;

    BigDecimal deposit;

    Location location;

    RentalStatus rentalStatus;

    PaymentStatus paymentStatus;

    public void setCar(AbstractCar car) {
        this.car = car;
    }

    public StaffMember getStaffMember() {
        return staffMember;
    }

    public void setStaffMember(StaffMember staffMember) {
        this.staffMember = staffMember;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
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
        this.car = (AbstractCar) car;
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
}
