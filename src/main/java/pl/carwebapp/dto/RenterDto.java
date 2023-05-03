package pl.carwebapp.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;

public class RenterDto {
    @NotBlank
    private String renterName;

    @NotBlank
    private String renterLastName;

    @NotBlank
    private String renterPlaceOfResidence;

    @NotBlank
    private String renterPhoneNumber;

    @PESEL
    private String renterPesel;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRenterPesel() {
        return renterPesel;
    }

    public void setRenterPesel(String renterPesel) {
        this.renterPesel = renterPesel;
    }

    public String getRenterPlaceOfResidence() {
        return renterPlaceOfResidence;
    }

    public void setRenterPlaceOfResidence(String renterPlaceOfResidence) {
        this.renterPlaceOfResidence = renterPlaceOfResidence;
    }

    public String getRenterPhoneNumber() {
        return renterPhoneNumber;
    }

    public void setRenterPhoneNumber(String renterPhoneNumber) {
        this.renterPhoneNumber = renterPhoneNumber;
    }
}
