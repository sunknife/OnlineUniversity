package autoleasing.controller.command;

import autoleasing.model.entity.Order;
import autoleasing.model.service.OrderService;

import javax.servlet.http.HttpServletRequest;

public class UserPayBillCommand implements Command{
    private OrderService orderService;

    public UserPayBillCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        Order order = (Order) servletRequest.getSession().getAttribute("order");
        order.setPaid(true);
        orderService.createOrder(order);
        return "/WEB-INF/user/userbase.jsp";
    }
}
