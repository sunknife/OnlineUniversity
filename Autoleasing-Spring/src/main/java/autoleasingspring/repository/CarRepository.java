package autoleasingspring.repository;

import autoleasingspring.entity.Car;
import autoleasingspring.entity.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {

    Optional<Car> findById(Long id);

    @Transactional
    @Modifying
    @Query("update Car u set u.model = :model, u.brand = :brand, u.carClass = :carClass, u.price = :price  where u.id = :id")
    void updateCar(String model, String brand, CarClass carClass, BigDecimal price, Long id);


}
