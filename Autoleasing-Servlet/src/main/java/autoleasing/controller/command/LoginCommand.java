package autoleasing.controller.command;

import autoleasing.model.entity.Role;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command{
    @Override
    public String execute(HttpServletRequest servletRequest) {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");

        if( username == null || username.equals("") || password == null || password.equals("")  ){
            return "/login.jsp";
        }

        //check user in db

        if(CommandUtility.checkUserIsLogged(servletRequest, username)){
            return "/WEB-INF/error.jsp";
        }
        //change to role in database
        if (username.equals("ilya@example.com")){
            CommandUtility.setUserRole(servletRequest, Role.ADMIN, username);
            return "/WEB-INF/admin/adminbase.jsp";
        } else if (username.equals("ihor@example.com")) {
            CommandUtility.setUserRole(servletRequest, Role.USER, username);
            return "/WEB-INF/user/userbase.jsp";
        } else if (username.equals("artem@example.com")){
            CommandUtility.setUserRole(servletRequest, Role.MANAGER, username);
            return "/WEB-INF/manager/managerbase.jsp";
        } else {
            System.out.println("Guest works");
            CommandUtility.setUserRole(servletRequest, Role.GUEST, username);
            return "/login.jsp";
        }
    }
}
