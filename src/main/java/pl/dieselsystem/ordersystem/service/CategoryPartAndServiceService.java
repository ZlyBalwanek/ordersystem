package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.CategoryPartAndService;
import pl.dieselsystem.ordersystem.repository.CategoryPartAndServiceRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class CategoryPartAndServiceService {

    @Autowired
    private CategoryPartAndServiceRepository categoryPartAndServiceRepository;

    @Autowired
    private EntityManager entityManager;

    public void create(CategoryPartAndService categoryPartAndService) {

        categoryPartAndServiceRepository.save(categoryPartAndService);

    }

    public CategoryPartAndService showById(long id) {

        return categoryPartAndServiceRepository.findById(id);

    }

    public List<CategoryPartAndService> showAll() {

        return categoryPartAndServiceRepository.findAll();

    }

    public void update(CategoryPartAndService categoryPartAndService) {

        entityManager.merge(categoryPartAndService);

    }

    public void delete(CategoryPartAndService categoryPartAndService) {

        entityManager.remove(entityManager.contains(categoryPartAndService) ?
                categoryPartAndService : entityManager.merge(categoryPartAndService));

    }

}
