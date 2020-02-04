package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.*;
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

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FaultService faultService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @Autowired
    private OperationService operationService;

    @Autowired
    private StatusService statusService;

    public void create(Order order) {

        orderRepository.save(order);

    }

    public Order showById(long id) {

        return orderRepository.findById(id);

    }

    public List<Order> findAll() {

        return orderRepository.findAll();

    }

    public void update(Order order) {

        entityManager.merge(order);

    }

    public void delete(Order order) {

        entityManager.remove(entityManager.contains(order) ?
                order : entityManager.merge(order));

    }

    public List<User> findAllUsers() {

        return userService.findAll();

    }

    public List<Category> findAllCategories() {

        return categoryService.findAll();

    }

    public List<Fault> findAllFaults() {

        return faultService.findAll();

    }

    public List<Customer> findAllCustomers() {

        return customerService.findAll();

    }

    public User findById(long id) {

        return userService.findById(id);

    }

    public void setStartingStatus(Order order) {

        Operation operation = new Operation();

        operation.setOrder(order);
        operation.setStatus(statusService.findById(1));
        operation.setUser(userService.findById(1));
        operation.setDescription("Description 1");

        operationService.create(operation);

    }

}
