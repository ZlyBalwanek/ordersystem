package pl.dieselsystem.ordersystem.model;

import javax.persistence.*;

@Entity(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Status() {
    }

}
