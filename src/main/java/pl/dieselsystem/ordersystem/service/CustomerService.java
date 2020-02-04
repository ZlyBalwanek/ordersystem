package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.Customer;
import pl.dieselsystem.ordersystem.repository.CustomerRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EntityManager entityManager;

    public void create(Customer customer) {

        customerRepository.save(customer);

    }

    public Customer findById(long id) {

        return customerRepository.findById(id);

    }

    public List<Customer> findAll() {

        return customerRepository.findAll();

    }

    public void update(Customer customer) {

        entityManager.merge(customer);

    }

    public void delete(Customer customer) {

        entityManager.remove(entityManager.contains(customer) ?
                customer : entityManager.merge(customer));

    }

}
