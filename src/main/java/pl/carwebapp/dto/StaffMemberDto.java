package pl.carwebapp.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;

public class StaffMemberDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String placeOfResidence;

    @NotBlank
    private String phoneNumber;

    @PESEL
    private String pesel;
    @NotBlank
    private String login;
    @NotBlank
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPesel() {
        return pesel;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
