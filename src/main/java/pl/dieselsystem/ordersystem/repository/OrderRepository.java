package pl.dieselsystem.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dieselsystem.ordersystem.model.Order;
import pl.dieselsystem.ordersystem.model.User;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findById(long id);

    List<Order> findAllByEmployeeAndCreatedAfter(User worker, LocalDateTime monthStart);
    List<Order> findAllByEmployeeAndCreatedBetween(User worker, LocalDateTime start, LocalDateTime end);
    List<Order> findAllByEmployeeAndOpenTrue(User worker);
    List<Order> findAllByOpenTrue();

}
