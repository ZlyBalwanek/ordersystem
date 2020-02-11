package pl.dieselsystem.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dieselsystem.ordersystem.model.User;
import pl.dieselsystem.ordersystem.service.UserService;

@Controller
@RequestMapping("/master/of/order")
public class MasterController {

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("user", new User());

        return "super/addUser";

    }

    @PostMapping("/create")
    public String create(@ModelAttribute User user) {



        userService.create(user);

    }
}
