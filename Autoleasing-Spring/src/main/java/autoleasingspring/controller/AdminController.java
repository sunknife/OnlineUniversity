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

/**
 * Class that represents admin zone endpoints
 * Every page will start from 'auth/admin' url
 */
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


    /**
     *  Method that used when admin blocks user from his cabinet.
     * @param id parameter specify which user to ban according his id in database
     * @param model parameter represents Model class which holds global values
     * @return starting page of admin
     */
    @GetMapping("/ban")
    public String blockUser(@RequestParam Long id, Model model){
        userService.updateUserStatus(id, Status.BLOCKED);
        model.addAttribute("users",userService.getAllUsers());
        return "admin";
    }

    /**
     * Method that used by admin to unblock user
     * @param id specify which user to unblock according his id in database
     * @param model represents Model class which holds global values
     * @return starting page of admin
     */
    @GetMapping("/unblock")
    public String unblockUser(@RequestParam Long id, Model model) {
        userService.updateUserStatus(id, Status.ACTIVE);
        model.addAttribute("users",userService.getAllUsers());
        return "admin";
    }

    /**
     * Method is called when admin goes to car menu page
     * @param model represents Model class which holds global values
     * @return cars page for admin
     */
    @GetMapping("/cars")
    public String adminCarsPage(Model model) {
        model.addAttribute("cars", carService.getAllCars());
        return "admin_cars";
    }

    /**
     * Method is called when admin adds new car to car list
     * @param car represents the car variable from car registration form
     * @param model represents Model class which holds global values
     * @return cars page for admin
     */
    @PostMapping("/save_new_car")
    public String saveNewCar(@ModelAttribute Car car, Model model) {
        carService.saveCar(car);
        model.addAttribute("cars", carService.getAllCars());
        return "admin_cars";
    }

    /**
     * Method is called when admin goes to car registration page
     * @param model represents Model class which holds global values
     * @return car registration page
     */
    @GetMapping("/addcar")
    public String addNewCarPage(Model model) {
        Car car = new Car();
        model.addAttribute("car",car);
        return "add_car";
    }

    /**
     * Method is called when admin select to edit some car from car menu
     * @param id specify the id of the car in datdbase
     * @param model represents Model class which holds global values
     * @return car edit page
     */
    @GetMapping("/cars/edit")
    public String editCar(@RequestParam Long id, Model model) {
        model.addAttribute("edit_car", carService.findCarById(id));
        return "edit_car";
    }

    /**
     * Method is called when admin tries to save edit of the car
     * @param edit_car represents updated variable of the car
     * @param model represents Model class which holds global values
     * @return car menu page
     */
    @PostMapping("/cars/save_edit_car")
    public String saveEditCar(@ModelAttribute Car edit_car,  Model model) {
        carService.updateCar(edit_car, edit_car.getId());;
        model.addAttribute("cars", carService.getAllCars());
        return "admin_cars";
    }

    /**
     * Method is called when admin select delete car button
     * @param id specify car id in database which should be deleted
     * @param model represents Model class which holds global values
     * @return car menu page
     */
    @GetMapping("/cars/delete")
    public String deleteCar(@RequestParam Long id, Model model) {
        carService.deleteCar(id);
        model.addAttribute("cars", carService.getAllCars());
        return "admin_cars";
    }


    /**
     * Method is called when admin selects add manager button
     * @param model represents Model class which holds global values
     * @return manager registration page
     */
    @GetMapping("/add_manager")
    public String addManager(Model model) {
        User manager = new User();
        model.addAttribute("manager", manager);
        return "manager_registration";
    }


    /**
     * Method is called when manager submit data from manager registration page
     * @param manager represents new manager from form
     * @param model represents Model class which holds global values
     * @return admin start page
     */
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
