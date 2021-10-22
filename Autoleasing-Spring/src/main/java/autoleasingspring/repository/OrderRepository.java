package autoleasingspring.repository;

import autoleasingspring.entity.Order;
import autoleasingspring.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Transactional
    @Query(value = "SELECT MAX( id ) FROM orders", nativeQuery = true)
    Long findLastRecordId();

    @Transactional
    @Modifying
    @Query("update Order u set u.isPaid = :isPaid where u.id = :id")
    void updateOrderPaidStatus(Boolean isPaid, Long id);

    @Transactional
    @Modifying
    @Query("update Order u set u.status = :status where u.id = :id")
    void updateOrderStatus(OrderStatus status, Long id);
}
