package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.Fault;
import pl.dieselsystem.ordersystem.repository.FaultRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class FaultService {

    @Autowired
    private FaultRepository faultRepository;

    @Autowired
    private EntityManager entityManager;

    public void create(Fault fault) {

        faultRepository.save(fault);

    }

    public Fault findById(long id) {

        return faultRepository.findById(id);

    }

    public List<Fault> findAll() {

        return faultRepository.findAll();

    }

    public void update(Fault fault) {

        entityManager.merge(fault);

    }

    public void delete(Fault fault) {

        entityManager.remove(entityManager.contains(fault) ?
                fault : entityManager.merge(fault));

    }

}
