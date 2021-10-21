package autoleasingspring.service;

import autoleasingspring.entity.Car;
import autoleasingspring.entity.CarClass;
import autoleasingspring.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
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

    public List<Car> getAllCarsSortedBy(String sorted_by, String sorted_dir) {
        return carRepository.findAll(Sort.by(Sort.Direction.fromString(sorted_dir), sorted_by));
    }

    public void saveCar(Car car){
        carRepository.save(car);
    }

    public void updateCar(Car car, Long id) {
        carRepository.updateCar(car.getModel(),car.getBrand(), car.getCarClass(), car.getPrice(), id);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    public List<Car> findCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public List<Car> findCarsByClass(CarClass carClass) {return carRepository.findByCarClass(carClass);}
}
