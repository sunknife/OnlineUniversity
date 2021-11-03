package autoleasing.controller.command;

import autoleasing.model.entity.CarClass;

import javax.servlet.http.HttpServletRequest;

public class AdminAddCarCommand implements Command{


    @Override
    public String execute(HttpServletRequest servletRequest) {
        servletRequest.getSession().setAttribute("carClassValues", CarClass.values());
        return "/WEB-INF/admin/add_car.jsp";
    }
}
