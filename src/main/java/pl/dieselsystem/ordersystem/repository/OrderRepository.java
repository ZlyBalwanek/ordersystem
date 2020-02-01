package pl.dieselsystem.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dieselsystem.ordersystem.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findById(long id);

}
