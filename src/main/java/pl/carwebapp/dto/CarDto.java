package pl.carwebapp.dto;

import pl.carwebapp.model.FuelType;
import pl.carwebapp.model.Transmission;
import pl.carwebapp.model.TypeOfDrive;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class CarDto {
    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @Min(1950)
    @Max(2020)
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

    public void setTypeOfDrive(TypeOfDrive typeOfDrive) {
        this.typeOfDrive = typeOfDrive;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }
}




