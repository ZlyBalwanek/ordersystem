package pl.dieselsystem.ordersystem.model;

import javax.persistence.*;

@Entity(name = "orders_parts_and_services")
public class OrderPartAndService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private PartAndService partAndService;

    private String description;
    private int price;
}
