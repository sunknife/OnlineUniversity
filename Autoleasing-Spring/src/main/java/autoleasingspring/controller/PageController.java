package autoleasingspring.controller;

import autoleasingspring.entity.Role;
import autoleasingspring.entity.Status;
import autoleasingspring.entity.User;
import autoleasingspring.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    private final UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;



    @Autowired
    public PageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String welcome(){
        return "index";
    }

    @GetMapping("/registration")
    public String registerUser(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "user_registration";
    }

    @PostMapping("/save_registration")
    public String saveUser(@ModelAttribute User user, Model model) {
        User readyUser = new User();
        readyUser.setFirstName(user.getFirstName());
        readyUser.setLastName(user.getLastName());
        readyUser.setEmail(user.getEmail());
        readyUser.setPassword(passwordEncoder.encode(user.getPassword()));
        readyUser.setRole(Role.USER);
        readyUser.setStatus(Status.ACTIVE);
        userService.saveUser(readyUser);
        return "index";
    }
}
