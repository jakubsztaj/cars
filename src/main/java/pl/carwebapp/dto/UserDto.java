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

    public String getRenterLastName() {
        return renterLastName;
    }

    public String getRenterPesel() {
        return renterPesel;
    }

    public String getRenterPlaceOfResidence() {
        return renterPlaceOfResidence;
    }

    public String getRenterPhoneNumber() {
        return renterPhoneNumber;
    }

    public String getRenterLogin() {
        return renterLogin;
    }

    public String getRenterPassword() {
        return renterPassword;
    }
}
