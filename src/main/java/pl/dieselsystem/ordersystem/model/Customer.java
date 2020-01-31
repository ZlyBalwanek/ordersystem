package pl.dieselsystem.ordersystem.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private Set<PhoneNumber> phoneNumbers = new HashSet<>();

    @OneToMany
    private Set<Order> orderSet = new HashSet<>();

    private String name;
    private String email;
    private boolean workshop = false;

    public Customer() {
    }
}
