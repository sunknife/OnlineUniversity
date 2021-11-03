package autoleasing.controller.command;

import javax.servlet.http.HttpServletRequest;

public class ErrorCommand implements Command {
    @Override
    public String execute(HttpServletRequest servletRequest) {
        return "/WEB-INF/error.jsp";
    }
}
