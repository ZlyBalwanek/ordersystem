package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.OrderPartAndService;
import pl.dieselsystem.ordersystem.repository.OrderPartAndServiceRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class OrderPartAndServiceService {

    @Autowired
    private OrderPartAndServiceRepository orderPartAndServiceRepository;

    @Autowired
    private EntityManager entityManager;

    public void create(OrderPartAndService orderPartAndService) {

        orderPartAndServiceRepository.save(orderPartAndService);

    }

    public OrderPartAndService showById(long id) {

        return orderPartAndServiceRepository.findById(id);

    }

    public List<OrderPartAndService> showAll() {

        return orderPartAndServiceRepository.findAll();

    }

    public void update(OrderPartAndService orderPartAndService) {

        entityManager.merge(orderPartAndService);

    }

    public void delete(OrderPartAndService orderPartAndService) {

        entityManager.remove(entityManager.contains(orderPartAndService) ?
                orderPartAndService : entityManager.merge(orderPartAndService));

    }

}
