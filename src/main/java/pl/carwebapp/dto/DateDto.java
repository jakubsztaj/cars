package pl.carwebapp.dto;

import java.time.LocalDate;

public class DateDto {
    protected LocalDate lastServiceDate;

    public LocalDate getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(LocalDate lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}
