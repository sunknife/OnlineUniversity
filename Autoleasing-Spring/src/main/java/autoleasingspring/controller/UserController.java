package autoleasingspring.controller;

import autoleasingspring.entity.Order;
import autoleasingspring.entity.OrderStatus;
import autoleasingspring.entity.User;
import autoleasingspring.service.CarService;
import autoleasingspring.service.OrderService;
import autoleasingspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/auth/cabinet")
public class UserController {

    private final CarService carService;
    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public UserController(CarService carService, UserService userService, OrderService orderService) {
        this.carService = carService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("")
    public String helloUser(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "cabinet";
    }

    @GetMapping("/order")
    public String orderFillStart(@RequestParam Long id, Model model, HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        //remove sout
        System.out.println(username);
        Optional<User> currentUser = userService.findByEmail(username);
        Order order = new Order();
        order.setCarId(id);
        order.setUserId(currentUser.get().getId());
        model.addAttribute("order", order);
        return "order";
    }

    @PostMapping("/save_order")
    public String orderFillEnd(@ModelAttribute Order order, Model model) {
        order.setStatus(OrderStatus.NEW);
        orderService.saveOrder(order);
        model.addAttribute("cars", carService.getAllCars());
        return "cabinet";
    }

}
