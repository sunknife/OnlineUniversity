package autoleasing.controller.command;

import autoleasing.model.entity.OrderStatus;
import autoleasing.model.service.OrderService;

import javax.servlet.http.HttpServletRequest;

public class ManagerUpdateOrderStatusCommand implements Command{

    private OrderService orderService;

    public ManagerUpdateOrderStatusCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        OrderStatus orderStatus = OrderStatus.valueOf(servletRequest.getParameter("newStatus"));
        Long orderId = Long.valueOf(servletRequest.getParameter("orderId"));
        orderService.updateOrderStatus(orderId,orderStatus);
        servletRequest.getSession().setAttribute("orders", orderService.findAll());
        return "/WEB-INF/manager/managerbase.jsp";
    }
}
