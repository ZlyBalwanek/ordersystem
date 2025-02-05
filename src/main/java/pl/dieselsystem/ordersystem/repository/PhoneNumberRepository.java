package pl.dieselsystem.ordersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dieselsystem.ordersystem.model.PhoneNumber;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long> {

    PhoneNumber findById(long id);

}
