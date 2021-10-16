package autoleasingspring.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "brand")
    private String brand;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "class")
    private CarClass carClass;
    @Column(name = "price", precision = 7, scale = 2)
    private BigDecimal price;
}
