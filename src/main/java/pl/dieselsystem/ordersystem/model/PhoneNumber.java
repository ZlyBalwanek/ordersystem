package pl.dieselsystem.ordersystem.model;

import javax.persistence.*;

@Entity(name = "phone_numbers")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Customer customer;

    private String number;

}
