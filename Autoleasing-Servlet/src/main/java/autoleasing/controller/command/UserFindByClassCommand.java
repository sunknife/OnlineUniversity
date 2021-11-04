package autoleasing.controller.command;

import autoleasing.model.entity.CarClass;
import autoleasing.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class UserFindByClassCommand implements Command{

    private CarService carService;

    public UserFindByClassCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        CarClass carClass = CarClass.valueOf(servletRequest.getParameter("carClass"));
        servletRequest.getSession().setAttribute("cars", carService.findCarsByClass(carClass));
        return "/WEB-INF/user/userbase.jsp";
    }
}
