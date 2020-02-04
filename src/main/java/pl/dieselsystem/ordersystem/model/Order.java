package pl.dieselsystem.ordersystem.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Operation> operationSet = new HashSet<>();

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private User creator;

    @ManyToOne
    private User worker = null;

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

    public Order() {
    }

    @PrePersist
    public void create() {

        created = LocalDateTime.now();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Operation> getOperationSet() {
        return operationSet;
    }

    public void setOperationSet(Set<Operation> operationSet) {
        this.operationSet = operationSet;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getWorker() {
        return worker;
    }

    public void setWorker(User worker) {
        this.worker = worker;
    }

    public Set<Fault> getFaultSet() {
        return faultSet;
    }

    public void setFaultSet(Set<Fault> faultSet) {
        this.faultSet = faultSet;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<OrderPartAndService> getOrderPartAndServiceSet() {
        return orderPartAndServiceSet;
    }

    public void setOrderPartAndServiceSet(Set<OrderPartAndService> orderPartAndServiceSet) {
        this.orderPartAndServiceSet = orderPartAndServiceSet;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", operationSet=" + operationSet +
                ", customer=" + customer +
                ", creator=" + creator +
                ", worker=" + worker +
                ", faultSet=" + faultSet +
                ", category=" + category +
                ", orderPartAndServiceSet=" + orderPartAndServiceSet +
                ", partNumber='" + partNumber + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                '}';
    }
}
