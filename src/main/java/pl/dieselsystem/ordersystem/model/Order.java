package pl.dieselsystem.ordersystem.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "orders") //TODO @NotNull, @NotEmpty and unique
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
    private User employee = null;

    @ManyToMany
    private Set<Fault> faultSet = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany
    private Set<OrderPartAndService> orderPartAndServiceSet = new HashSet<>();

    private String partNumber;
    private String serialNumber;
    private String description;
    private LocalDateTime created;
    private boolean open = true;

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

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
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

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", operationSet=" + operationSet +
                ", customer=" + customer.getName() +
                ", creator=" + creator.getName() +
                ", worker=" + employee.getName() +
                ", faultSet=" + faultSet +
                ", category=" + category.getCategory() +
                ", orderPartAndServiceSet=" + orderPartAndServiceSet +
                ", partNumber='" + partNumber + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", open=" + open +
                '}';
    }
}
