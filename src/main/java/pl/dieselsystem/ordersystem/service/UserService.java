package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.Role;
import pl.dieselsystem.ordersystem.model.User;
import pl.dieselsystem.ordersystem.repository.RoleRepository;
import pl.dieselsystem.ordersystem.repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    public void create(User user, boolean admin) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Role role = admin == true ? roleRepository.findByName("ADMIN") : roleRepository.findByName("EMPLOYEE");
        user.setRole(role);

        userRepository.save(user);

    }

    public User findById(long id) {

        return userRepository.findById(id);

    }

    public User findByName(String name) {

        return userRepository.findByName(name);

    }

    public List<User> findAll() {

        return userRepository.findAll();

    }

    public void update(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        entityManager.merge(user);

    }

    public void delete(User user) {

        entityManager.remove(entityManager.contains(user) ?
                user : entityManager.merge(user));

    }

}
