package autoleasingspring.controller;

import autoleasingspring.entity.OrderStatus;
import autoleasingspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth/manager")
public class ManagerController {

    private final OrderService orderService;

    @Autowired
    public ManagerController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public String helloManager(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "manager";
    }

    @GetMapping("/update")
    public String updateOrder(@RequestParam OrderStatus newStatus, @RequestParam Long orderId, Model model) {
        orderService.updateOrderStatus(newStatus, orderId);
        model.addAttribute("orders", orderService.getAllOrders());
        return "manager";
    }

}
