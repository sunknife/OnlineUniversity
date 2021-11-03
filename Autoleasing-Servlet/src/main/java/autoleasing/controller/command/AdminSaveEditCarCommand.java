package autoleasing.controller.command;

import autoleasing.model.entity.Car;
import autoleasing.model.entity.CarClass;
import autoleasing.model.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class AdminSaveEditCarCommand implements Command{

    private CarService carService;

    public AdminSaveEditCarCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        Long carId = Long.valueOf(servletRequest.getParameter("id"));
        String model = servletRequest.getParameter("model");
        String brand = servletRequest.getParameter("brand");
        CarClass carClass = CarClass.valueOf(servletRequest.getParameter("carClass"));
        BigDecimal price = new BigDecimal(servletRequest.getParameter("price"));
        Car car = new Car(carId,model,brand,carClass,price);
        carService.updateCar(car);
        servletRequest.getSession().setAttribute("cars", carService.findAll());
        return "/WEB-INF/admin/admin_cars.jsp";
    }
}
