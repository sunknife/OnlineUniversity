package autoleasing.controller.command;

import autoleasing.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class UserOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest servletRequest) {
        Long carId = Long.valueOf(servletRequest.getParameter("id"));
        Long userId = ((User)servletRequest.getSession().getAttribute("user")).getId();
        servletRequest.getSession().setAttribute("carId", carId);
        servletRequest.getSession().setAttribute("userId", userId);
        return "/WEB-INF/user/order.jsp";
    }
}
