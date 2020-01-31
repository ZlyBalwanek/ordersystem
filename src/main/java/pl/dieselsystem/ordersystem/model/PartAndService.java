package pl.dieselsystem.ordersystem.model;

import javax.persistence.*;

@Entity(name = "parts_and_services")
public class PartAndService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private CategoryPartAndService categoryPartAndService;

    @ManyToOne
    private OrderPartAndService orderPartAndService;

    private String name;
    private int price;
    private boolean part = true;
}
