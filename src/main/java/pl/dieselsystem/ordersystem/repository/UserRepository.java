package pl.dieselsystem.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dieselsystem.ordersystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findById(long id);

}
