package pl.carwebapp.dto;

public class RenterDto {
    String renterName;
    String renterLastName;
    String renterPesel;

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
}