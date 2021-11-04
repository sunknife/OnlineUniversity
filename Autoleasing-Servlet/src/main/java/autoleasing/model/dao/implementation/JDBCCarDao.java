package autoleasing.model.dao.implementation;

import autoleasing.model.dao.CarDao;
import autoleasing.model.dao.mapper.CarMapper;
import autoleasing.model.entity.Car;
import autoleasing.model.entity.CarClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCCarDao implements CarDao {
    private Connection connection;

    public JDBCCarDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Car entity) {
        try (PreparedStatement preparedStatement = connection.
                prepareCall("INSERT INTO cars (model, brand, class, price) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, entity.getModel());
            preparedStatement.setString(2, entity.getBrand());
            preparedStatement.setString(3,entity.getCarClass().toString());
            preparedStatement.setBigDecimal(4,entity.getPrice());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public Car findById(long id) {
        Car car = null;
        try (PreparedStatement preparedStatement = connection.prepareCall("SELECT * FROM cars WHERE id=?")){
            preparedStatement.setLong(1, id);
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            CarMapper mapper = new CarMapper();
            if (resultSet.next()) {
                car = mapper.extractFromResultSet(resultSet);
            }
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return car;
    }

    @Override
    public List<Car> findAll() {
        List<Car> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareCall("SELECT * FROM cars")) {
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            CarMapper mapper = new CarMapper();
            while (resultSet.next()) {
                result.add(mapper.extractFromResultSet(resultSet));
            }
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    @Override
    public void update(Car entity) {
        try (PreparedStatement preparedStatement = connection.
                prepareCall("UPDATE cars SET model=?, brand=?, class=?, price=? WHERE id = ?")) {
            preparedStatement.setString(1, entity.getModel());
            preparedStatement.setString(2, entity.getBrand());
            preparedStatement.setString(3, entity.getCarClass().toString());
            preparedStatement.setBigDecimal(4,entity.getPrice());
            preparedStatement.setLong(5, entity.getId());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(long id) {
        try (PreparedStatement preparedStatement = connection.prepareCall("DELETE FROM cars WHERE id = ?")) {
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public void close() {

    }

    @Override
    public List<Car> sortByColumnAndDirection(String sort_by, String sort_dir) {
        List<Car> result = new ArrayList<>();
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM cars ORDER BY ");
        queryBuilder.append(sort_by);
        queryBuilder.append(" ");
        queryBuilder.append(sort_dir.toUpperCase());
        try (PreparedStatement preparedStatement = connection.prepareCall(queryBuilder.toString())){
                ResultSet resultSet = preparedStatement.executeQuery();
                CarMapper mapper = new CarMapper();
                while (resultSet.next()) {
                    result.add(mapper.extractFromResultSet(resultSet));
                }

        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    @Override
    public List<Car> findCarsByBrand(String brand) {
        List<Car> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareCall("SELECT * FROM cars WHERE brand = ?")){
            preparedStatement.setString(1, brand);
            ResultSet resultSet = preparedStatement.executeQuery();
            CarMapper mapper = new CarMapper();
            while (resultSet.next()) {
                result.add(mapper.extractFromResultSet(resultSet));
            }
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    @Override
    public List<Car> findCarByClass(CarClass carClass) {
        List<Car> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareCall("SELECT * FROM cars WHERE class = ?")){
            preparedStatement.setString(1, carClass.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            CarMapper mapper = new CarMapper();
            while (resultSet.next()) {
                result.add(mapper.extractFromResultSet(resultSet));
            }
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }
}
