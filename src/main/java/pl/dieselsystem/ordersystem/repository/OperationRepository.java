package pl.dieselsystem.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dieselsystem.ordersystem.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {

    Operation findById(long id);

}
