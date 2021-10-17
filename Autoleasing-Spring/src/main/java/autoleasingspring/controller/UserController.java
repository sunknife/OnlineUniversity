package autoleasingspring.controller;

import autoleasingspring.service.CarService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth/cabinet")
public class UserController {

    private final CarService carService;

    @Autowired
    public UserController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public String helloUser(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "cabinet";
    }

    @GetMapping("/order")
    public String orderFillStart(@RequestParam Long id, Model model) {
        return "order";
    }

}
