package pl.carwebapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Renter extends AbstractPerson {

    protected String renterName;

    protected String renterLastName;
    @Id
    protected String renterId;


    public Renter(String renterName, String renterLastName, String randomPersonalIdNumber) {
        super(renterName, renterLastName, randomPersonalIdNumber);
    }

    public Renter() {
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getRenterLastName() {
        return renterLastName;
    }

    public void setRenterLastName(String renterLastName) {
        this.renterLastName = renterLastName;
    }

    public String getRenterId() {
        return renterId;
    }

    public void setRenterId(String renterId) {
        this.renterId = renterId;
    }

}
