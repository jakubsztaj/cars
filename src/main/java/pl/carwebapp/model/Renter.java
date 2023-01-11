package pl.carwebapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Renter extends AbstractPerson {

    @Id
    protected String renterId;

    protected String email;


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

    public Renter() {
    }

    public String getRenterId() {
        return renterId;
    }

    public void setRenterId(String renterId) {
        this.renterId = renterId;
    }


}
