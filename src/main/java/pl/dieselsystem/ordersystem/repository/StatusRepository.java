package pl.dieselsystem.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dieselsystem.ordersystem.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {

    Status findById(long id);

}
