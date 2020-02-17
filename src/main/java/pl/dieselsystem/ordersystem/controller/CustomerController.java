package pl.dieselsystem.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dieselsystem.ordersystem.model.Customer;
import pl.dieselsystem.ordersystem.model.PhoneNumber;
import pl.dieselsystem.ordersystem.service.CustomerService;
import pl.dieselsystem.ordersystem.service.PhoneNumberService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("customer", new Customer());

        return "user/customer/create";

    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer, @RequestParam String phone1, @RequestParam(required = false) String phone2) {

        PhoneNumber phoneNumber1 = new PhoneNumber();
        phoneNumber1.setNumber(phone1);
        phoneNumber1.setCustomer(customer);

        customer.getPhoneNumbers().add(phoneNumber1);

        if (!phone2.isEmpty()) {

            PhoneNumber phoneNumber2 = new PhoneNumber();
            phoneNumber2.setNumber(phone2);
            phoneNumber2.setCustomer(customer);

            customer.getPhoneNumbers().add(phoneNumber2);

        }

            customerService.create(customer);

        return "user/index";

    }

}
