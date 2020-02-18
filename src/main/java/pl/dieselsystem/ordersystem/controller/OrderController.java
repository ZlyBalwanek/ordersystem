package pl.dieselsystem.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dieselsystem.ordersystem.model.*;
import pl.dieselsystem.ordersystem.service.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/create1step")
    public String create1step() {

        return "user/order/create1step";

    }

    @GetMapping("/create2step")
    public String create2step(Model model, @RequestParam long id) {

        Order order = new Order();
        order.setCustomer(customerService.findById(id));

        model.addAttribute("order", order);

        return "user/order/create2step";

    }

    @GetMapping("/create3step")
    public String create3step(@ModelAttribute Order order) {

        return "user/order/create3step";

    }

    @PostMapping("/create")
    public String create(@ModelAttribute Order order) {

        order.setCreator(orderService.findByUserId(1));
        orderService.setStartingStatus(order);

        orderService.create(order);

        return "user/done";

    }

    @GetMapping("/show")
    public String showAll(Model model) {

        model.addAttribute("orders", orderService.findAll());

        return "user/order/showAll";

    }

    @GetMapping("/show/{id}")
    public String showAll(Model model, @PathVariable long id) {

        model.addAttribute("order", orderService.findById(id));

        return "user/order/show";

    }

    @ModelAttribute("customerList")
    public List<Customer> customerList() {

        return orderService.findAllCustomers();

    }

    @ModelAttribute("faultList")
    public List<Fault> faultList() {

        return orderService.findAllFaults();

    }

    @ModelAttribute("userList")
    public List<User> userList() {

        return orderService.findAllUsers();

    }

    @ModelAttribute("categories")
    public Category[] categoriesList() {

        return Category.values();

    }

}
