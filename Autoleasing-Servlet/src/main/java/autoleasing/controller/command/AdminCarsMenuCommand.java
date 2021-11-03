package autoleasing.controller.command;

import autoleasing.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class AdminCarsMenuCommand implements Command {

    private CarService carService;

    public AdminCarsMenuCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        servletRequest.getSession().setAttribute("cars", carService.findAll());
        return "/WEB-INF/admin/admin_cars.jsp";
    }
}
