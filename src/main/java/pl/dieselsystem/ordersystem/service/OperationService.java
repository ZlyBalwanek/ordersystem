package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.Operation;
import pl.dieselsystem.ordersystem.repository.OperationRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private EntityManager entityManager;

    public void create(Operation operation) {

        operationRepository.save(operation);

    }

    public Operation showById(long id) {

        return operationRepository.findById(id);

    }

    public List<Operation> showAll() {

        return operationRepository.findAll();

    }

    public void update(Operation operation) {

        entityManager.merge(operation);

    }

    public void delete(Operation operation) {

        entityManager.remove(entityManager.contains(operation) ?
                operation : entityManager.merge(operation));

    }

}
