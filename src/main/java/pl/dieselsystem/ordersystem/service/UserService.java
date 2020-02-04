package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.User;
import pl.dieselsystem.ordersystem.repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    public void create(User user) {

        userRepository.save(user);

    }

    public User findById(long id) {

        return userRepository.findById(id);

    }

    public List<User> findAll() {

        return userRepository.findAll();

    }

    public void update(User user) {

        entityManager.merge(user);

    }

    public void delete(User user) {

        entityManager.remove(entityManager.contains(user) ?
                user : entityManager.merge(user));

    }

}
