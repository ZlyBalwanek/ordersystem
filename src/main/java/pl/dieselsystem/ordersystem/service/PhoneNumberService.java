package pl.dieselsystem.ordersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dieselsystem.ordersystem.model.PhoneNumber;
import pl.dieselsystem.ordersystem.repository.PhoneNumberRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class PhoneNumberService {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    private EntityManager entityManager;

    public void create(PhoneNumber phoneNumber) {

        phoneNumberRepository.save(phoneNumber);

    }

    public PhoneNumber showById(long id) {

        return phoneNumberRepository.findById(id);

    }

    public List<PhoneNumber> showAll() {

        return phoneNumberRepository.findAll();

    }

    public void update(PhoneNumber phoneNumber) {

        entityManager.merge(phoneNumber);

    }

    public void delete(PhoneNumber phoneNumber) {

        entityManager.remove(entityManager.contains(phoneNumber) ?
                phoneNumber : entityManager.merge(phoneNumber));

    }

}
