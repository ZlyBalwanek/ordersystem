package pl.dieselsystem.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.dieselsystem.ordersystem.model.User;
import pl.dieselsystem.ordersystem.service.UserService;

@Controller
@RequestMapping("/master/of/order")
public class MasterController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {

        return "super/index";

    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("user", new User());

        return "super/addUser";

    }

    @PostMapping("/create")
    public String create(@ModelAttribute User user, @RequestParam boolean admin) {

            userService.create(user, admin);

        return "super/done";

    }

    @GetMapping("/show")
    public String showAll(Model model) {

        model.addAttribute("users", userService.findAll());

        return "super/showAll";

    }
}
