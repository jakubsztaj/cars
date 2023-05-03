package pl.carwebapp.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class AbstractPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_osoby")
    private Long personId;

    public AbstractPerson() {
    }

    public AbstractPerson(String firstName, String lastName, String placeOfResidence, String pesel, String phoneNumber, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.placeOfResidence = placeOfResidence;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    public AbstractPerson(String renterName, String renterLastName, String placeOfResidence, String randomPersonalIdNumber, String randomPhoneNumber) {
    }


    @Column(name = "imie")
    private String firstName;
    @Column(name = "nazwisko")
    private String lastName;
    @Column(name = "pesel")
    private String pesel;
    @Column(name = "miejsce_zamieszkania")
    private String placeOfResidence;
    @Column(name = "numer_telefonu")
    private String phoneNumber;
    @Column(name = "login")
    private String username;
    @Column(name = "haslo")
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

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
