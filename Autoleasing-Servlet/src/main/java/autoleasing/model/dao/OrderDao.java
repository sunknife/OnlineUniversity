package autoleasing.model.dao;

import autoleasing.model.entity.Order;
import autoleasing.model.entity.OrderStatus;

public interface OrderDao extends GenericDao<Order> {
    void updateOrderStatus(Long id, OrderStatus orderStatus);
}
