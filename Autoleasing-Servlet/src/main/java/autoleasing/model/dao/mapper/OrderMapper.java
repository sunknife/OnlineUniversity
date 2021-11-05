package autoleasing.model.dao.mapper;

import autoleasing.model.entity.Order;
import autoleasing.model.entity.OrderStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

public class OrderMapper implements ObjectMapper<Order>{
    @Override
    public Order extractFromResultSet(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getLong("id"));
        order.setUserId(resultSet.getLong("user_id"));
        order.setCarId(resultSet.getLong("car_id"));
        order.setPassport(resultSet.getString("passport"));
        order.setWithDriver(resultSet.getBoolean("is_with_driver"));
        order.setStartDate(LocalDate.parse(resultSet.getString("start_date")));
        order.setEndDate(LocalDate.parse(resultSet.getString("end_date")));
        order.setPrice(resultSet.getBigDecimal("price"));
        order.setPaid(resultSet.getBoolean("is_paid"));
        order.setStatus(OrderStatus.valueOf(resultSet.getString("status")));
        return order;
    }

    @Override
    public Order makeUnique(Map<Long, Order> cache, Order entity) {
        cache.putIfAbsent(entity.getUserId(), entity);
        return cache.get(entity.getUserId());
    }
}
