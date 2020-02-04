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

    public OrderPartAndService() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PartAndService getPartAndService() {
        return partAndService;
    }

    public void setPartAndService(PartAndService partAndService) {
        this.partAndService = partAndService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
