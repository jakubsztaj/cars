package pl.carwebapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Renter extends AbstractPerson {

    @Id
    protected String renterId;


    public Renter(String renterName, String renterLastName, String randomPersonalIdNumber) {
        super(renterName, renterLastName, randomPersonalIdNumber);
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
