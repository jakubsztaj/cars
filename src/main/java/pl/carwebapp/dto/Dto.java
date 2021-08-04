package pl.carwebapp.dto;

public class Dto {
    public static class CarDto {
        String name;
        String type;
        int manufacturingYear;
        String category;

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

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }
}
