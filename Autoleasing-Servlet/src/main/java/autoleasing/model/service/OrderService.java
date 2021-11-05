package autoleasing.model.service;

import autoleasing.model.dao.DaoFactory;
import autoleasing.model.dao.OrderDao;
import autoleasing.model.entity.Order;
import autoleasing.model.entity.OrderStatus;

import java.util.List;

public class OrderService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public void createOrder(Order order) {
        try (OrderDao orderDao = daoFactory.createOrderDao()) {
            orderDao.create(order);
        }
    }

    public List<Order> findAll() {
        List<Order> result;
        try (OrderDao orderDao = daoFactory.createOrderDao()) {
            result = orderDao.findAll();
        }
        return result;
    }

    public void updateOrderStatus(Long id, OrderStatus orderStatus) {
        try(OrderDao orderDao = daoFactory.createOrderDao()) {
            orderDao.updateOrderStatus(id,orderStatus);
        }
    }
}
