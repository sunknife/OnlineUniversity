package autoleasing.controller.command;

import javax.servlet.http.HttpServletRequest;

public class AdminBaseCommand implements Command{
    @Override
    public String execute(HttpServletRequest servletRequest) {
        return "/WEB-INF/admin/adminbase.jsp";
    }
}
