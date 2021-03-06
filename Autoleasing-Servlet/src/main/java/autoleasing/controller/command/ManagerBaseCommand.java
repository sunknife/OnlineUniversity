package autoleasing.controller.command;

import autoleasing.model.entity.OrderStatus;
import autoleasing.model.service.OrderService;

import javax.servlet.http.HttpServletRequest;

public class ManagerBaseCommand implements Command{

    private OrderService orderService;

    public ManagerBaseCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        servletRequest.getSession().setAttribute("orderStatus", OrderStatus.values());
        servletRequest.getSession().setAttribute("orders", orderService.findAll());
        return "/WEB-INF/manager/managerbase.jsp";
    }
}
