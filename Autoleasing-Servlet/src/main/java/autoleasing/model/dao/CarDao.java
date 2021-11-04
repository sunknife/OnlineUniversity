package autoleasing.model.dao;

import autoleasing.model.entity.Car;
import autoleasing.model.entity.CarClass;

import java.util.List;

public interface CarDao extends GenericDao<Car> {
    List<Car> sortByColumnAndDirection(String sort_by, String sort_dir);

    List<Car> findCarsByBrand(String brand);

    List<Car> findCarByClass(CarClass carClass);
}
