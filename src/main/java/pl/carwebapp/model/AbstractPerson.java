package pl.carwebapp.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class AbstractPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_osoby")
    private Long personId;
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
    private String login;
    @Column(name = "haslo")
    private String password;

    public AbstractPerson() {
    }

    public AbstractPerson(String firstName, String lastName, String placeOfResidence, String pesel, String phoneNumber, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.placeOfResidence = placeOfResidence;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
