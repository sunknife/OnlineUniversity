package autoleasing.controller.command;

import autoleasing.model.service.CarService;

import javax.servlet.http.HttpServletRequest;

public class UserBaseSortCommand implements Command{

    private CarService carService;

    public UserBaseSortCommand(CarService carService) {
        this.carService = carService;
    }

    @Override
    public String execute(HttpServletRequest servletRequest) {
        String sorted_by = servletRequest.getParameter("sort_by");
        String direction = servletRequest.getParameter("dir");
        servletRequest.getSession().setAttribute("direction", direction.equals("asc")? "desc" : "asc");
        servletRequest.getSession().setAttribute("cars", carService.getAllCarsSortedBy(sorted_by,direction));
        return "/WEB-INF/user/userbase.jsp";
    }
}
