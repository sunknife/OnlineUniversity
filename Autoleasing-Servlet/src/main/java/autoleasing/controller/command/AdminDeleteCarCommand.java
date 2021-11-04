package autoleasing.controller.command;

import autoleasing.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class AdminDeleteCarCommand implements Command{
    private CarService carService;

    public AdminDeleteCarCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        Long carId = Long.valueOf(servletRequest.getParameter("id"));
        carService.deleteCar(carId);
        servletRequest.getSession().setAttribute("cars", carService.findAll());
        return "/WEB-INF/admin/admin_cars.jsp";
    }
}
