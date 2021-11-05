package autoleasing.model.dao.implementation;

import autoleasing.model.dao.OrderDao;
import autoleasing.model.dao.mapper.OrderMapper;
import autoleasing.model.entity.Order;
import autoleasing.model.entity.OrderStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        List<Order> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareCall("SELECT * FROM orders")) {
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            OrderMapper mapper = new OrderMapper();
            while (resultSet.next()) {
                result.add(mapper.extractFromResultSet(resultSet));
            }
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
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

    @Override
    public void updateOrderStatus(Long id, OrderStatus orderStatus) {
        try (PreparedStatement preparedStatement = connection.prepareCall("UPDATE orders SET status = ? WHERE id = ?")) {
            preparedStatement.setString(1,orderStatus.toString());
            preparedStatement.setLong(2,id);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
