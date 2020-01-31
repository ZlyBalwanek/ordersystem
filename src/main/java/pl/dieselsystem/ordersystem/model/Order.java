package pl.dieselsystem.ordersystem.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private Set<Operation> operationSet = new HashSet<>();

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private User creator;

    @ManyToOne
    private User worker;

    @ManyToMany
    private Set<Fault> faultSet = new HashSet<>();

    @ManyToOne
    private Category category;

    @OneToMany
    private Set<OrderPartAndService> orderPartAndServiceSet = new HashSet<>();

    private String partNumber;
    private String serialNumber;
    private String description;
    private LocalDateTime created;

}
