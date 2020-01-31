package pl.dieselsystem.ordersystem.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Status status;

    @ManyToOne
    private Order order;

    private String description;
    private LocalDateTime operationTime;

    @PrePersist
    public void created() {

        operationTime = LocalDateTime.now();

    }

}
