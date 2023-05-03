package pl.carwebapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "platnosc")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_platnosci")
    private Long paymentId;

    @ManyToOne
    private Renter renter;

    public Payment(PaymentStatus paymentStatus, BigDecimal pricePerDay) {
        this.paymentStatus = paymentStatus;
        this.pricePerDay = pricePerDay;
    }

    public Payment() {

    }

    @Column(name = "status_platnosci")
    PaymentStatus paymentStatus;

    @Column(name = "cena_za_dobe")
    BigDecimal pricePerDay;

    public Long getId() {
        return paymentId;
    }

    public void setId(Long id) {
        paymentId = id;
    }

    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
}
