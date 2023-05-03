package pl.carwebapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pracownik")
public class StaffMember extends AbstractPerson {

    private Long staffMemberId;

    public StaffMember(String role) {
        this.role = role;
    }

    @Column(name = "rola")
    private String role;

    public StaffMember() {
        super();
    }

    public Long getStaffMemberId() {
        return staffMemberId;
    }

    public void setStaffMemberId(Long staffMemberId) {
        this.staffMemberId = staffMemberId;
    }
}
