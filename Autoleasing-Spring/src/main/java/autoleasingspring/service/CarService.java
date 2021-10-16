package autoleasingspring.service;

import autoleasingspring.entity.Car;
import autoleasingspring.entity.CarClass;
import autoleasingspring.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void saveCar(Car car){
        carRepository.save(car);
    }

    public void updateCar(Car car, Long id) {
        carRepository.updateCar(car.getModel(),car.getBrand(), car.getCarClass(), car.getPrice(), id);
    }

    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }
}
