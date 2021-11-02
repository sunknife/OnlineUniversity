package autoleasing.controller.command;

import autoleasing.model.entity.Status;
import autoleasing.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class AdminBanUserCommand implements Command{

    private UserService userService;

    public AdminBanUserCommand(UserService userService) {
        this.userService = userService;
    }


    @Override
    public String execute(HttpServletRequest servletRequest) {
        Long userId = Long.valueOf(servletRequest.getParameter("id"));
        userService.updateStatus(userId, Status.BLOCKED);
        servletRequest.getSession().setAttribute("users", userService.findAll());
        return "/WEB-INF/admin/adminbase.jsp";
    }
}
