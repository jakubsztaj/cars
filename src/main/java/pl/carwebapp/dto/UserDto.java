package pl.carwebapp.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;

public class UserDto {
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
    private String renterLogin;
    @NotBlank
    private String renterPassword;

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

    public String getRenterLogin() {
        return renterLogin;
    }

    public void setRenterLogin(String renterLogin) {
        this.renterLogin = renterLogin;
    }

    public String getRenterPassword() {
        return renterPassword;
    }

    public void setRenterPassword(String renterPassword) {
        this.renterPassword = renterPassword;
    }
}
