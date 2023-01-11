package pl.carwebapp.dto;

import org.hibernate.validator.constraints.pl.PESEL;

import javax.validation.constraints.NotBlank;

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