package autoleasingspring.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "user_id")
    Long userId;
    @Column(name = "car_id")
    Long carId;
    @Column(name = "passport")
    String passport;
    @Column(name = "is_with_driver")
    Boolean isWithDriver;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    LocalDate endDate;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    OrderStatus status;
}
