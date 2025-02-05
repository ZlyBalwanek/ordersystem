package pl.dieselsystem.ordersystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "parts_and_services")
public class PartAndService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    private Set<CategoryPartAndService> categoryPartAndServiceSet;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String name;
    private int price;
    private boolean part = true;

    public PartAndService() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<CategoryPartAndService> getCategoryPartAndServiceSet() {
        return categoryPartAndServiceSet;
    }

    public void setCategoryPartAndServiceSet(Set<CategoryPartAndService> categoryPartAndServiceSet) {
        this.categoryPartAndServiceSet = categoryPartAndServiceSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isPart() {
        return part;
    }

    public void setPart(boolean part) {
        this.part = part;
    }
}
