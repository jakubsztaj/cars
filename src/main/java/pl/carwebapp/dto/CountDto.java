package pl.carwebapp.dto;

public class CountDto {
    String name;
    Integer value;

    public CountDto(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

}
