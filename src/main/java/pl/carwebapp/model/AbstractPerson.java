package pl.carwebapp.model;

public abstract class AbstractPerson {
    public AbstractPerson(String firstName, String lastName, String placeOfResidence, String pesel, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.placeOfResidence = placeOfResidence;
        this.pesel = pesel;
        this.phoneNumber = phoneNumber;
    }

    private String firstName;

    private String lastName;

    private String pesel;

    private String placeOfResidence;

    private String phoneNumber;

    public AbstractPerson() {

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
