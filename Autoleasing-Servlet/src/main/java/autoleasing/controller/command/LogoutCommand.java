package autoleasing.controller.command;

import autoleasing.model.entity.Role;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command{
    @Override
    public String execute(HttpServletRequest servletRequest) {
        CommandUtility.setUserRole(servletRequest, Role.GUEST, "");
        System.out.println("logoutCommand works");
        return "redirect:/index.jsp";
    }
}
