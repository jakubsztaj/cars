package pl.carwebapp.dto;

import org.hibernate.validator.constraints.pl.PESEL;

import javax.validation.constraints.NotBlank;

public class OwnerDto {

    @NotBlank
    private String ownerName;

    @NotBlank
    private String ownerLastName;

    @PESEL
    private String ownerPesel;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerPesel() {
        return ownerPesel;
    }

    public void setOwnerPesel(String ownerPesel) {
        this.ownerPesel = ownerPesel;
    }
}
