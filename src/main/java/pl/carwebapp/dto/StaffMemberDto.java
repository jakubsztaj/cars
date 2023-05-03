package pl.carwebapp.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class StaffMemberDto {

    @NotBlank
    private String staffMemberName;

    @NotBlank
    private String staffMemberLastName;

    @NotBlank
    private String staffMemberPlaceOfResidence;

    @NotBlank
    private String staffMemberPhoneNumber;

    @PESEL
    private String staffMemberPesel;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String staffMemberRole;

    public String getStaffMemberRole() {
        return staffMemberRole;
    }

    public void setStaffMemberRole(String staffMemberRole) {
        this.staffMemberRole = staffMemberRole;
    }

    public String getStaffMemberName() {
        return staffMemberName;
    }

    public void setStaffMemberName(String staffMemberName) {
        this.staffMemberName = staffMemberName;
    }

    public String getStaffMemberLastName() {
        return staffMemberLastName;
    }

    public void setStaffMemberLastName(String staffMemberLastName) {
        this.staffMemberLastName = staffMemberLastName;
    }

    public String getStaffMemberPlaceOfResidence() {
        return staffMemberPlaceOfResidence;
    }

    public void setStaffMemberPlaceOfResidence(String staffMemberPlaceOfResidence) {
        this.staffMemberPlaceOfResidence = staffMemberPlaceOfResidence;
    }

    public String getStaffMemberPhoneNumber() {
        return staffMemberPhoneNumber;
    }

    public void setStaffMemberPhoneNumber(String staffMemberPhoneNumber) {
        this.staffMemberPhoneNumber = staffMemberPhoneNumber;
    }

    public String getStaffMemberPesel() {
        return staffMemberPesel;
    }

    public void setStaffMemberPesel(String staffMemberPesel) {
        this.staffMemberPesel = staffMemberPesel;
    }

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
}
