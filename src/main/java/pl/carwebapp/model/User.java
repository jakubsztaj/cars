package pl.carwebapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "uzytkownik")
public class User extends AbstractPerson {
    @Column(name = "id_użytkownika")
    private Long renterId;

    @Column(name = "email")
    protected String email;

    public User() {
    }

    public User(String renterName, String renterLastName, String placeOfResidence, String randomPersonalIdNumber, String randomPhoneNumber, String renterLogin, String renterPassword) {
        super(renterName, renterLastName, placeOfResidence, randomPersonalIdNumber, randomPhoneNumber, renterLogin, renterPassword);
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
