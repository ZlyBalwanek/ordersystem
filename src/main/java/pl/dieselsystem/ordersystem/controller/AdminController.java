package pl.dieselsystem.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dieselsystem.ordersystem.service.OrderService;

@Controller
@RequestMapping("/user")
public class AdminController {

    @Autowired
    public OrderService orderService;

    @GetMapping("/index")
    public String index() {

        return "user/index";

    }

}
