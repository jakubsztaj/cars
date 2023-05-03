package pl.carwebapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Renter extends AbstractPerson {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long renterId;

    protected String email;

    public Renter() {
    }

    public Renter(String renterName, String renterLastName, String placeOfResidence, String randomPersonalIdNumber, String randomPhoneNumber) {
        super(renterName, renterLastName, placeOfResidence, randomPersonalIdNumber, randomPhoneNumber);
        this.email = renterName + "." + renterLastName + "@gmail.com";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getRenterId() {
        return renterId;
    }

    public void setRenterId(Long renterId) {
        this.renterId = renterId;
    }

}
