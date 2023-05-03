package pl.carwebapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class StaffMember {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany
    private List<Renter> renter;

    public StaffMember(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public StaffMember() {
        super();
    }

    private String username;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Renter> getRenter() {
        return renter;
    }

    public void setRenter(List<Renter> renter) {
        this.renter = renter;
    }
}
