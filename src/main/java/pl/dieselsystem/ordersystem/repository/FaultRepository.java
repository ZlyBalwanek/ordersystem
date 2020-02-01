package pl.dieselsystem.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dieselsystem.ordersystem.model.Fault;

@Repository
public interface FaultRepository extends JpaRepository<Fault,Long> {
}
