package autoleasingspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/cabinet")
    public String getCabinetPage() {
        return "cabinet";
    }
}
