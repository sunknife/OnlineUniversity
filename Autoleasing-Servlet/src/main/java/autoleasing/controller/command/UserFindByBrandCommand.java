package autoleasing.controller.command;

import autoleasing.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class UserFindByBrandCommand implements Command{
    private CarService carService;

    public UserFindByBrandCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        String brand = servletRequest.getParameter("brand");
        servletRequest.getSession().setAttribute("cars",carService.findCarsByBrand(brand));
        return "/WEB-INF/user/userbase.jsp";
    }
}
