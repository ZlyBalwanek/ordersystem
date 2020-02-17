package pl.dieselsystem.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dieselsystem.ordersystem.model.PartAndService;
import pl.dieselsystem.ordersystem.service.PartAndServiceService;

@Controller
@RequestMapping("/pas")
public class PartAndServiceController {

    @Autowired
    private PartAndServiceService partAndServiceService;

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("pas", new PartAndService());

        return "user/partAndService/create";

    }

    @PostMapping
    public String create(@ModelAttribute PartAndService pas) {

        partAndServiceService.create(pas);

        return "user/index";

    }
}
