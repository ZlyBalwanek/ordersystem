package pl.dieselsystem.ordersystem.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "categories_parts_and_services")
public class CategoryPartAndService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private PartAndService partAndService;

    public CategoryPartAndService() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public PartAndService getPartAndService() {
        return partAndService;
    }

    public void setPartAndService(PartAndService partAndService) {
        this.partAndService = partAndService;
    }
}