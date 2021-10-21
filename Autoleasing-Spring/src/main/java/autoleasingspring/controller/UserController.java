package autoleasingspring.controller;

import autoleasingspring.entity.*;
import autoleasingspring.service.CarService;
import autoleasingspring.service.OrderService;
import autoleasingspring.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.Period;
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
        model.addAttribute("direction", "asc");
        return "cabinet";
    }

    @GetMapping("/")
    public String sortForUser(@RequestParam String sort_by,@RequestParam String sort_dir, Model model) {
        model.addAttribute("direction", sort_dir.equals("asc") ? "desc" : "asc");
        model.addAttribute("cars", carService.getAllCarsSortedBy(sort_by, sort_dir));
        return "cabinet";
    }

    @GetMapping("/filter-by-brand")
    public String filterByBrand(@RequestParam String brand, Model model) {
        model.addAttribute("direction", "asc");
        model.addAttribute("cars", carService.findCarsByBrand(brand));
        return "cabinet";
    }

    @GetMapping("/filter-by-class")
    public String filterByClass(@RequestParam CarClass carClass, Model model) {
        model.addAttribute("direction", "asc");
        model.addAttribute("cars", carService.findCarsByClass(carClass));
        return "cabinet";
    }

    @GetMapping("/order")
    public String orderFillStart(@RequestParam Long id, Model model, HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        Optional<User> currentUser = userService.findByEmail(username);
        Order order = new Order();
        order.setCarId(id);
        order.setUserId(currentUser.get().getId());
        model.addAttribute("order", order);
        return "order";
    }

    @PostMapping("/save_order")
    public String orderFillEnd(@ModelAttribute Order order, Model model) {
        model.addAttribute("order", order);
        Period period = Period.between(order.getStartDate(),order.getEndDate());
        Optional<Car> car = carService.findCarById(order.getCarId());
        BigDecimal carPrice = car.get().getPrice();
        int orderDays = period.getDays();
        boolean isDriverOrdered = order.getIsWithDriver();
        BigDecimal totalPrice =BigDecimal.valueOf(isDriverOrdered?100:0).add(carPrice).multiply(BigDecimal.valueOf(orderDays));
        order.setPrice(totalPrice);
        order.setStatus(OrderStatus.NEW);
        order.setIsPaid(false);
        orderService.saveOrder(order);
        Long lastOrder = orderService.getLastRecordId();
        model.addAttribute("orderDuration", orderDays);
        model.addAttribute("carPrice",carPrice);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("carName", car.get().getBrand() + " " + car.get().getModel());
        model.addAttribute("orderId", lastOrder);
        return "bill";
    }

    @PostMapping("/bill")
    public String payTheBill(@RequestParam Long orderId, Model model){
        orderService.updatePaidStatus(true, orderId);
        model.addAttribute("direction", "asc");
        model.addAttribute("cars", carService.getAllCars());
        return "cabinet";
    }

}
