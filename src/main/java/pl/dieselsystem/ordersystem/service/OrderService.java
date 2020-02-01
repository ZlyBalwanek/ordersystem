package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.Order;
import pl.dieselsystem.ordersystem.repository.OrderRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EntityManager entityManager;

    public void create(Order order) {

        orderRepository.save(order);

    }

    public Order showById(long id) {

        return orderRepository.findById(id);

    }

    public List<Order> showAll() {

        return orderRepository.findAll();

    }

    public void update(Order order) {

        entityManager.merge(order);

    }

    public void delete(Order order) {

        entityManager.remove(entityManager.contains(order) ?
                order : entityManager.merge(order));

    }

}
