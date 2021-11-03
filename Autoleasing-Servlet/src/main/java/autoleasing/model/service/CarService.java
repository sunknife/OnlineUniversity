package autoleasing.model.service;

import autoleasing.model.dao.CarDao;
import autoleasing.model.dao.DaoFactory;
import autoleasing.model.entity.Car;

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
}
