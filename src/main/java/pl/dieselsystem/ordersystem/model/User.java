package pl.dieselsystem.ordersystem.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    private Set<Order> orderSet = new HashSet<>();

    private String name;
    private String email;
    private String password;
    private String role;

    public User() {
    }

}
