package autoleasing.controller.command;

import autoleasing.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class UserBaseCommand implements Command{
    private CarService carService;

    public UserBaseCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        servletRequest.getSession().setAttribute("cars", carService.findAll());
        servletRequest.getSession().setAttribute("direction","asc");
        return "/WEB-INF/user/userbase.jsp";
    }
}
