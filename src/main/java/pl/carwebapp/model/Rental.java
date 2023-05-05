package pl.carwebapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "wypozyczenie")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_wypozyczenia")
    private Long rentalId;

    @ManyToOne
    private User user;

    @OneToOne
    private Car car;

    @OneToOne
    private StaffMember staffMember;

    @OneToMany
    @JoinColumn(name = "id_wypozyczenia")
    private List<Payment> payment;

    @Column(name = "data_rozpoczecia_wypozyczenia")
    LocalDateTime rentalBegin;

    @Column(name = "data_zakonczenia_wypozyczenia")
    LocalDateTime rentalEnd;

    @Column(name = "cena_za_dobe")
    BigDecimal pricePerDay;

    @Column(name = "depozyt")
    BigDecimal deposit;
    @Column(name = "lokalizacja")
    Location location;

    @Column(name = "stats_wypozyczenia")
    RentalStatus rentalStatus;

    @Column(name = "status_platnosci")
    PaymentStatus paymentStatus;

    public Rental() {
    }

    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }

    public void setCar(Car car) {
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

    public User getRenter() {
        return user;
    }

    public void setRenter(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
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
