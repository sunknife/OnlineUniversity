package autoleasing.model.service;

import autoleasing.model.dao.DaoFactory;
import autoleasing.model.dao.OrderDao;
import autoleasing.model.entity.Order;

public class OrderService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public void createOrder(Order order) {
        try (OrderDao orderDao = daoFactory.createOrderDao()) {
            orderDao.create(order);
        }
    }
}
