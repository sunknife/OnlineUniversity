package autoleasing.controller.command;

import autoleasing.model.entity.Car;
import autoleasing.model.entity.Order;
import autoleasing.model.entity.OrderStatus;
import autoleasing.model.service.CarService;
import autoleasing.model.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class UserSaveOrderCommand implements Command{

    private CarService carService;

    public UserSaveOrderCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        Order order = new Order();
        Long carId = Long.valueOf(servletRequest.getParameter("carId"));
        Long userId = Long.valueOf(servletRequest.getParameter("userId"));
        String passport = servletRequest.getParameter("passport");
        Boolean isWithDriver = Boolean.valueOf(servletRequest.getParameter("isWithDriver"));
        LocalDate startDate = LocalDate.parse(servletRequest.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(servletRequest.getParameter("endDate"));
        Period period = Period.between(startDate,endDate);
        int orderPeriod = period.getDays();
        Car car = carService.findById(carId);
        BigDecimal carPrice = car.getPrice();
        BigDecimal totalPrice = BigDecimal.valueOf(isWithDriver? 100: 0).add(carPrice).multiply(BigDecimal.valueOf(orderPeriod));
        order.setUserId(userId);
        order.setCarId(carId);
        order.setPassport(passport);
        order.setWithDriver(isWithDriver);
        order.setStartDate(startDate);
        order.setEndDate(endDate);
        order.setPrice(totalPrice);
        order.setStatus(OrderStatus.NEW);
        order.setPaid(false);
        servletRequest.getSession().setAttribute("orderDuration", orderPeriod);
        servletRequest.getSession().setAttribute("carPrice", carPrice);
        servletRequest.getSession().setAttribute("driverOption", isWithDriver? "100.00$" : "0.00$");
        servletRequest.getSession().setAttribute("totalPrice", totalPrice);
        servletRequest.getSession().setAttribute("carName", car.getBrand() + " " + car.getModel());
        servletRequest.getSession().setAttribute("order", order);

        return "/WEB-INF/user/bill.jsp";
    }
}
