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

    @Enumerated(EnumType.STRING)
    private Status status = Status.accept;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Order order;

    private String description;
    private LocalDateTime operationTime;

    @PrePersist
    public void created() {

        operationTime = LocalDateTime.now();

    }

    public Operation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }
}
