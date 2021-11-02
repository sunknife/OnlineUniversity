package autoleasing.controller.command;

import javax.servlet.http.HttpServletRequest;

public class AdminAddManagerCommand implements Command{
    @Override
    public String execute(HttpServletRequest servletRequest) {
        return "/WEB-INF/admin/manager_registration.jsp";
    }
}
