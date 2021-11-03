package autoleasing.controller.command;

import autoleasing.model.entity.Car;
import autoleasing.model.entity.CarClass;
import autoleasing.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class AdminEditCarCommand implements Command {
    private CarService carService;

    public AdminEditCarCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {

        Long carId = Long.valueOf(servletRequest.getParameter("id"));
        servletRequest.getSession().setAttribute("carClassValues", CarClass.values());
        servletRequest.getSession().setAttribute("edit_car", carService.findById(carId));
        return "/WEB-INF/admin/edit_car.jsp";
    }
}
