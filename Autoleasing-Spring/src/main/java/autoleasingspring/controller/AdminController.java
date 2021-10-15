package autoleasingspring.controller;

import autoleasingspring.entity.Status;
import autoleasingspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
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

}
