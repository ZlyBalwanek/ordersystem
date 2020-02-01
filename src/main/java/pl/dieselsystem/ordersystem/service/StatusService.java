package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.Status;
import pl.dieselsystem.ordersystem.repository.StatusRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private EntityManager entityManager;

    public void create(Status status) {

        statusRepository.save(status);

    }

    public Status showById(long id) {

        return statusRepository.findById(id);

    }

    public List<Status> showAll() {

        return statusRepository.findAll();

    }

    public void update(Status status) {

        entityManager.merge(status);

    }

    public void delete(Status status) {

        entityManager.remove(entityManager.contains(status) ?
                status : entityManager.merge(status));

    }

}
