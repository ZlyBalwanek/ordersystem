package pl.dieselsystem.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dieselsystem.ordersystem.model.OrderPartAndService;

@Repository
public interface OrderPartAndServiceRepository extends JpaRepository<OrderPartAndService,Long> {

    OrderPartAndService findById(long id);

}
