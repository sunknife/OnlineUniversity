package autoleasing.controller.command;

import autoleasing.model.entity.Role;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command{
    @Override
    public String execute(HttpServletRequest servletRequest) {
        CommandUtility.setUserRole(servletRequest, Role.GUEST, "Guest");
        return "redirect:/index.jsp";
    }
}
