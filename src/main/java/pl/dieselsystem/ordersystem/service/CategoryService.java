package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.Category;
import pl.dieselsystem.ordersystem.repository.CategoryRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EntityManager entityManager;

    public void create(Category category) {

        categoryRepository.save(category);

    }

    public Category showById(long id) {

        return categoryRepository.findById(id);

    }

    public List<Category> showAll() {

        return categoryRepository.findAll();

    }

    public void update(Category category) {

        entityManager.merge(category);

    }

    public void delete(Category category) {

        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));

    }

}
