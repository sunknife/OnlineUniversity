package autoleasingspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/manager")
public class ManagerController {

    @GetMapping("")
    public String helloManager() {
        return "manager";
    }

}
