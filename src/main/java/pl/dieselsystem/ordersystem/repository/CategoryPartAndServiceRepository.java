package pl.dieselsystem.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dieselsystem.ordersystem.model.CategoryPartAndService;

@Repository
public interface CategoryPartAndServiceRepository extends JpaRepository<CategoryPartAndService,Long> {
}
