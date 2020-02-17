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

    @Autowired
    private PhoneNumberService phoneNumberService;

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("customer", new Customer());

        return "user/customer/create";

    }

    @PostMapping
    public String create(@ModelAttribute Customer customer, @RequestParam String number1, @RequestParam String number2) {

        PhoneNumber phoneNumber1 = new PhoneNumber();
        phoneNumber1.setNumber(number1);
        phoneNumber1.setCustomer(customer);
        phoneNumberService.create(phoneNumber1);

        customer.getPhoneNumbers().add(phoneNumber1);

        if (!(Integer.parseInt(number2) == -1)) {

            PhoneNumber phoneNumber2 = new PhoneNumber();
            phoneNumber2.setNumber(number2);
            phoneNumber2.setCustomer(customer);
            phoneNumberService.create(phoneNumber2);

            customer.getPhoneNumbers().add(phoneNumber2);

        }

            customerService.create(customer);

        return "user/index";

    }

}
