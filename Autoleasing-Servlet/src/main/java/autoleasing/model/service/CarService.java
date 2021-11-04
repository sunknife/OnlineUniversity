package autoleasing.model.service;

import autoleasing.model.dao.CarDao;
import autoleasing.model.dao.DaoFactory;
import autoleasing.model.entity.Car;
import autoleasing.model.entity.CarClass;

import java.util.List;

public class CarService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Car> findAll() {
        List<Car> result;
        try (CarDao carDao = daoFactory.createCarDao()) {
            result = carDao.findAll();
        }
        return result;
    }

    public Car findById (Long id) {
        Car car;
        try (CarDao carDao = daoFactory.createCarDao()){
            car = carDao.findById(id);
        }
        return car;
    }

    public void updateCar(Car car) {
        try (CarDao carDao = daoFactory.createCarDao()) {
            carDao.update(car);
        }
    }

    public void addCar(Car car) {
        try (CarDao carDao = daoFactory.createCarDao()) {
            carDao.create(car);
        }
    }

    public void deleteCar(Long id) {
        try (CarDao carDao = daoFactory.createCarDao()) {
            carDao.delete(id);
        }
    }

    public List<Car> getAllCarsSortedBy(String sorted_by, String sort_dir) {
        List<Car> result;
        try (CarDao carDao = daoFactory.createCarDao()) {
            result = carDao.sortByColumnAndDirection(sorted_by,sort_dir);
        }
        return result;
    }

    public List<Car> findCarsByBrand(String brand) {
        List<Car> result;
        try (CarDao carDao = daoFactory.createCarDao()){
            result = carDao.findCarsByBrand(brand);
        }
        return result;
    }

    public List<Car> findCarsByClass(CarClass carClass) {
        List<Car> result;
        try (CarDao carDao = daoFactory.createCarDao()){
            result = carDao.findCarByClass(carClass);
        }
        return result;
    }
}
