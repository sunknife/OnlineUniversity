package autoleasing.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {

    Long id;
    Long userId;
    Long carId;
    String passport;
    Boolean isWithDriver;
    LocalDate startDate;
    LocalDate endDate;
    BigDecimal price;
    Boolean isPaid;
    OrderStatus status;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Boolean getWithDriver() {
        return isWithDriver;
    }

    public void setWithDriver(Boolean withDriver) {
        isWithDriver = withDriver;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", carId=" + carId +
                ", passport='" + passport + '\'' +
                ", isWithDriver=" + isWithDriver +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", isPaid=" + isPaid +
                ", status=" + status +
                '}';
    }
}
