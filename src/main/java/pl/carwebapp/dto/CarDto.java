package pl.carwebapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import pl.carwebapp.model.FuelType;
import pl.carwebapp.model.Segment;
import pl.carwebapp.model.Transmission;
import pl.carwebapp.model.TypeOfDrive;

public class CarDto {
    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @Min(1950)
    @Max(2023)
    private int manufacturingYear;

    @Min(1)
    private double mpg;

    private Transmission transmission;

    private FuelType fuelType;

    private TypeOfDrive typeOfDrive;

    private int price;

    public TypeOfDrive getTypeOfDrive() {
        return typeOfDrive;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public int getPrice() {
        return price;
    }

    public double getMpg() {
        return mpg;
    }

}




