package autoleasing.controller.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest servletRequest);
}
