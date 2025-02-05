package pl.dieselsystem.ordersystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.dieselsystem.ordersystem.model.Order;
import pl.dieselsystem.ordersystem.model.User;
import pl.dieselsystem.ordersystem.service.OrderService;
import pl.dieselsystem.ordersystem.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(Model model) {

        model.addAttribute("title", "Witaj");

        return "employee/index";

    }

    @GetMapping("/findOrder")
    public String getOrder() {

        return "employee/getOrderById";

    }

    @GetMapping("/getOrder")
    public String getOrder(Model model, @PathVariable long id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        Order order = orderService.findById(id);

        if (order.getEmployee() == null) {

            model.addAttribute("order", order);

            return "employee/acceptOrder.jsp";

        } else if (order.getEmployee() == user) {

            model.addAttribute("order", order);

            return "redirect:/editOrder";

        }

        return "employee/accessDenied";

    }

    @GetMapping("/editOrder")
    public String editOrder(@ModelAttribute Order order) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        return ""; //TODO complete

    }

    @GetMapping("/showMonthly")
    public String showMonthlyOrders(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        List<Order> orderList = orderService.findAllByEmployeeAndCreatedAfter(user);

        model.addAttribute("orders", orderList);

        return "employee/showAllOrders";

    }

    @GetMapping("/setDataRange") //TODO don't show calendars
    public String setDataRange() {

        return "employee/setData";

    }

    @GetMapping("/showOrderByDataRange")
    public String showOrderByDataRange(Model model, @PathVariable String start, @PathVariable String end) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        LocalDateTime minDate = LocalDateTime.parse(start);
        LocalDateTime maxDate = LocalDateTime.parse(end);

        List<Order> orderList = orderService.findAllByEmployeeAndCreatedBetween(user, minDate, maxDate);

        model.addAttribute("orders", orderList);

        return "employee/showAllOrder.jsp";

    }

    @GetMapping("/showOpen")
    public String showOpen(Model model) {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();

        User user = userService.findById(2);

        model.addAttribute("orders", orderService.findAllByOpenTrue());

        return "employee/showAllOrders";

    }

//    @ModelAttribute("user")
//    public User logged() {
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return (User)authentication.getPrincipal();
//
//    }

}
