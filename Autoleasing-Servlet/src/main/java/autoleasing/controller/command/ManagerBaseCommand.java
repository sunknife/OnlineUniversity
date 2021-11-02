package autoleasing.controller.command;

import javax.servlet.http.HttpServletRequest;

public class ManagerBaseCommand implements Command{
    @Override
    public String execute(HttpServletRequest servletRequest) {
        return "/WEB-INF/manager/managerbase.jsp";
    }
}
