package pl.carwebapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pracownik")
public class StaffMember extends AbstractPerson {

    private Long staffMemberId;

    @Column(name = "rola")
    protected String role;

    public StaffMember(String firstName, String lastName, String placeOfResidence, String pesel, String phoneNumber, String login, String password) {
        super(firstName, lastName, placeOfResidence, pesel, phoneNumber, login, password);
        this.role = "admin";
    }

    public StaffMember() {
        super();
    }

    public Long getStaffMemberId() {
        return staffMemberId;
    }

    public void setStaffMemberId(Long staffMemberId) {
        this.staffMemberId = staffMemberId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
