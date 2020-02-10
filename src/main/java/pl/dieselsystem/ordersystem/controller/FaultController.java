package pl.dieselsystem.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dieselsystem.ordersystem.model.Fault;
import pl.dieselsystem.ordersystem.service.FaultService;

@Controller
@RequestMapping("/fault")
public class FaultController {

    @Autowired
    FaultService faultService;

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("fault", new Fault());

        return "fault/create";

    }

    @PostMapping("/create")
    public String create(@ModelAttribute Fault fault) {

        faultService.create(fault);

        return "index";

    }

    @GetMapping("/show")
    public String show(Model model) {

        model.addAttribute("faults", faultService.findAll());

        return "fault/showAll";

    }

}
