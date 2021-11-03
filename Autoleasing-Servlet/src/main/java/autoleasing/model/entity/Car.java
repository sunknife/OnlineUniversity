package autoleasing.model.entity;

import java.math.BigDecimal;

public class Car {

    private Long id;
    private String model;
    private String brand;
    private CarClass carClass;
    private BigDecimal price;

    public Car() {
    }

    public Car(Long id, String model, String brand, CarClass carClass, BigDecimal price) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.carClass = carClass;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", carClass=" + carClass +
                ", price=" + price +
                '}';
    }
}
