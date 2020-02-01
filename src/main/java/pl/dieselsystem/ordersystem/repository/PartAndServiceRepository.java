package pl.dieselsystem.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dieselsystem.ordersystem.model.PartAndService;

@Repository
public interface PartAndServiceRepository extends JpaRepository<PartAndService,Long> {

    PartAndService findById(long id);

}
