package autoleasing.model.dao.implementation;

import autoleasing.model.dao.OrderDao;
import autoleasing.model.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class JDBCOrderDao implements OrderDao {
    private Connection connection;

    public JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Order entity) {
        try (PreparedStatement preparedStatement = connection.
                prepareCall("INSERT INTO orders (user_id, car_id, passport, is_with_driver, start_date, end_date, price, is_paid, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setLong(1, entity.getUserId());
            preparedStatement.setLong(2, entity.getCarId());
            preparedStatement.setString(3, entity.getPassport());
            preparedStatement.setBoolean(4, entity.getWithDriver());
            preparedStatement.setString(5, String.valueOf(entity.getStartDate()));
            preparedStatement.setString(6, String.valueOf(entity.getEndDate()));
            preparedStatement.setBigDecimal(7, entity.getPrice());
            preparedStatement.setBoolean(8, entity.getPaid());
            preparedStatement.setString(9,entity.getStatus().toString());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @Override
    public Order findById(long id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void close() {

    }
}
