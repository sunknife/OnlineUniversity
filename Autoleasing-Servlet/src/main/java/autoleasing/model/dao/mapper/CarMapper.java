package autoleasing.model.dao.mapper;

import autoleasing.model.entity.Car;
import autoleasing.model.entity.CarClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CarMapper implements ObjectMapper<Car>{
    @Override
    public Car extractFromResultSet(ResultSet resultSet) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getLong("id"));
        car.setModel(resultSet.getString("model"));
        car.setBrand(resultSet.getString("brand"));
        car.setCarClass(CarClass.valueOf(resultSet.getString("class")));
        car.setPrice(resultSet.getBigDecimal("price"));
        return car;
    }

    @Override
    public Car makeUnique(Map<Long, Car> cache, Car entity) {
        cache.putIfAbsent(entity.getId(), entity);
        return cache.get(entity.getId());
    }
}
