package by.aginskiy.autopark.model.entity;

import by.aginskiy.autopark.util.IdGenerator;

import java.math.BigDecimal;

public class Car {

    private int id = IdGenerator.getId();
    private String brand;
    private String model;
    private int releaseYear;
    private Color color;
    private BigDecimal price;
    private String registrationNumber;

    public Car() {

    }

    public Car(String brand, String model, int releaseYear, Color color, BigDecimal price, String registrationNumber) {
        this.brand = brand;
        this.model = model;
        this.releaseYear = releaseYear;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;

        return id == car.id &&
                releaseYear == car.releaseYear &&
                (brand != null && brand.equals(car.brand)) &&
                (model != null && model.equals(car.model)) &&
                color == car.color &&
                (price != null && price.equals(car.price)) &&
                (registrationNumber != null && registrationNumber.equals(car.registrationNumber));
        
    }

    @Override
    public int hashCode() {
        final int multiplier = 31;
        int result = id;

        result = multiplier * result + (brand != null ? brand.hashCode() : 0);
        result = multiplier * result + (model != null ? model.hashCode() : 0);
        result = multiplier * result + releaseYear;
        result = multiplier * result + (color != null ? color.hashCode() : 0);
        result = multiplier * result + (price != null ? price.hashCode() : 0);
        result = multiplier * result + (registrationNumber != null ? registrationNumber.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", releaseYear=").append(releaseYear);
        sb.append(", color=").append(color);
        sb.append(", price=").append(price);
        sb.append(", registrationNumber='").append(registrationNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
