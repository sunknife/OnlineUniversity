package autoleasingspring.service;

import autoleasingspring.entity.Order;
import autoleasingspring.entity.OrderStatus;
import autoleasingspring.repository.OrderRepository;
import javafx.scene.layout.BorderImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Long getLastRecordId() {
        return orderRepository.findLastRecordId();
    }

    public void updatePaidStatus(Boolean isPaid, Long id){
        orderRepository.updateOrderPaidStatus(isPaid, id);
    }

    public void updateOrderStatus(OrderStatus status, Long id) {
        orderRepository.updateOrderStatus(status,id);
    }
}
