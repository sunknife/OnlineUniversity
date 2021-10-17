package autoleasingspring.controller;

import autoleasingspring.entity.Car;
import autoleasingspring.entity.Role;
import autoleasingspring.entity.Status;
import autoleasingspring.entity.User;
import autoleasingspring.service.CarService;
import autoleasingspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth/admin")
public class AdminController {
    private final UserService userService;
    private final CarService carService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(UserService userService, CarService carService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.carService = carService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/ban")
    public String blockUser(@RequestParam Long id, Model model){
        userService.updateUserStatus(id, Status.BLOCKED);
        model.addAttribute("users",userService.getAllUsers());
        return "admin";
    }

    @GetMapping("/unblock")
    public String unblockUser(@RequestParam Long id, Model model) {
        userService.updateUserStatus(id, Status.ACTIVE);
        model.addAttribute("users",userService.getAllUsers());
        return "admin";
    }

    @GetMapping("/cars")
    public String adminCarsPage(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "admin_cars";
    }

    @PostMapping("/save_new_car")
    public String saveNewCar(@ModelAttribute Car car, Model model) {
        carService.saveCar(car);
        model.addAttribute("cars", carService.getAllCars());
        return "admin_cars";
    }

    @GetMapping("/addcar")
    public String addNewCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car",car);
        return "add_car";
    }

    @GetMapping("/cars/edit")
    public String editCar(@RequestParam Long id, Model model) {
        model.addAttribute("edit_car", carService.findCarById(id));
        return "edit_car";
    }

    @PostMapping("/cars/save_edit_car")
    public String saveEditCar(@ModelAttribute Car edit_car,  Model model) {
        carService.updateCar(edit_car, edit_car.getId());;
        model.addAttribute("cars", carService.getAllCars());
        return "admin_cars";
    }

    @GetMapping("/cars/delete")
    public String deleteCar(@RequestParam Long id, Model model) {
        carService.deleteCar(id);
        model.addAttribute("cars", carService.getAllCars());
        return "admin_cars";
    }

    @GetMapping("/add_manager")
    public String addManager(Model model) {
        User manager = new User();
        model.addAttribute("manager", manager);
        return "manager_registration";
    }

    @PostMapping("/save_manager")
    public String saveManager(@ModelAttribute User manager,Model model){
        manager.setRole(Role.MANAGER);
        manager.setStatus(Status.ACTIVE);
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        userService.saveUser(manager);
        model.addAttribute("users",userService.getAllUsers());
        return "admin";
    }

}
