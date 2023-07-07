package pl.carwebapp.dto;

import jakarta.validation.constraints.NotBlank;
import pl.carwebapp.model.Location;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RentalDto {
    @NotBlank
    private String pesel;

    @NotBlank
    private String vin;

    private LocalDateTime begin;

    private LocalDateTime end;

    private BigDecimal deposit;

    private Location location;

    public Location getLocation() {
        return location;
    }


    public BigDecimal getDeposit() {
        return deposit;
    }

    public String getPesel() {
        return pesel;
    }

    public String getVin() {
        return vin;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}
