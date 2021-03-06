package autoleasing.controller.command;

import autoleasing.model.entity.Role;
import autoleasing.model.entity.User;
import autoleasing.model.service.UserService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LoginCommand implements Command{

    private UserService userService;


    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        if( username == null || username.equals("") || password == null || password.equals("")  ){
            return "/login.jsp";
        }

        Optional<User> user = userService.login(username);

        if (!user.isPresent()) {
            return "/login.jsp";
        } else if (BCrypt.checkpw(password,user.get().getPassword())) {

            servletRequest.getSession().setAttribute("user", user.get());
            servletRequest.getSession().setAttribute("role", user.get().getRole());
            servletRequest.getSession().setAttribute("username",user.get().getEmail());

            if (CommandUtility.checkUserIsLogged(servletRequest, username)) {
                return "/WEB-INF/error.jsp";
            }

            if (user.get().getRole().equals(Role.ADMIN)) {
                CommandUtility.setUserRole(servletRequest, Role.ADMIN, username);
                servletRequest.getSession().setAttribute("users", userService.findAll());
                return "redirect:/admin";
            } else if (user.get().getRole().equals(Role.USER)) {
                CommandUtility.setUserRole(servletRequest, Role.USER, username);
                return "redirect:/user";
            } else if (user.get().getRole().equals(Role.MANAGER)) {
                CommandUtility.setUserRole(servletRequest, Role.MANAGER, username);
                return "redirect:/manager";
            } else {
                CommandUtility.setUserRole(servletRequest, Role.GUEST, username);
                return "/login.jsp";
            }
        }
        return "/login.jsp";
    }
}
