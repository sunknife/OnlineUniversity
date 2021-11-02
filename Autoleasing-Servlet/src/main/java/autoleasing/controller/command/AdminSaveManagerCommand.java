package autoleasing.controller.command;

import autoleasing.model.entity.Role;
import autoleasing.model.entity.Status;
import autoleasing.model.entity.User;
import autoleasing.model.service.UserService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;

public class AdminSaveManagerCommand implements Command{

    private UserService userService;

    public AdminSaveManagerCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        String firstName = servletRequest.getParameter("firstName");
        String lastName = servletRequest.getParameter("lastName");
        String email = servletRequest.getParameter("email");
        String password = servletRequest.getParameter("password");
        User manager = new User();
        manager.setFirstName(firstName);
        manager.setLastName(lastName);
        manager.setEmail(email);
        manager.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(12)));
        manager.setStatus(Status.ACTIVE);
        manager.setRole(Role.MANAGER);
        userService.addUser(manager);
        servletRequest.getSession().setAttribute("users", userService.findAll());
        return "/WEB-INF/admin/adminbase.jsp";
    }
}
