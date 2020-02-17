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

    @GetMapping("/deactivate/{id}")
    public String deactivate(Model model, @PathVariable long id) {

        model.addAttribute("user", userService.findById(id));

        return "super/deactivate";

    }

    @PostMapping("/deactivate")
    public String deactivate(@ModelAttribute User user) {

        User user1 = userService.findById(user.getId());

        user1.setActivate(false);

        userService.update(user1);

        return "super/done";

    }

    @GetMapping("/reactivate/{id}")
    public String reactivate(Model model, @PathVariable long id) {

        model.addAttribute("user", userService.findById(id));

        return "super/reactivate";

    }

    @PostMapping("/reactivate")
    public String reactivate(@ModelAttribute User user) {

        User user1 = userService.findById(user.getId());

        user1.setActivate(true);

        userService.update(user1);

        return "super/done";

    }

    @GetMapping("/passReset/{id}")
    public String passReset(Model model, @PathVariable long id) {

        model.addAttribute("user", userService.findById(id));

        return "super/passReset";

    }

    @PostMapping("/passReset")
    public String passReset(@ModelAttribute User user) {

        User user1 = userService.findById(user.getId());

        user1.setPassword(user.getPassword());

        userService.update(user1);

        return "super/done";

    }
}
