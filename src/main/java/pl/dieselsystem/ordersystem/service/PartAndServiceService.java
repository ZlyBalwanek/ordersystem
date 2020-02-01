package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.PartAndService;
import pl.dieselsystem.ordersystem.repository.PartAndServiceRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class PartAndServiceService {

    @Autowired
    private PartAndServiceRepository partAndServiceRepository;

    @Autowired
    private EntityManager entityManager;

    public void create(PartAndService partAndService) {

        partAndServiceRepository.save(partAndService);

    }

    public PartAndService showById(long id) {

        return partAndServiceRepository.findById(id);

    }

    public List<PartAndService> showAll() {

        return partAndServiceRepository.findAll();

    }

    public void update(PartAndService partAndService) {

        entityManager.merge(partAndService);

    }

    public void delete(PartAndService partAndService) {

        entityManager.remove(entityManager.contains(partAndService) ?
                partAndService : entityManager.merge(partAndService));

    }

}
