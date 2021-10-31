package autoleasing.controller.command;

import autoleasing.model.entity.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

public class LogoutCommand implements Command{
    @Override
    public String execute(HttpServletRequest servletRequest) {
        CommandUtility.setUserRole(servletRequest, Role.GUEST, "");
        System.out.println("logoutCommand works");
        HttpSession session = servletRequest.getSession();
        HashSet<String> loggedUsers = (HashSet<String>) session.
                getServletContext().
                getAttribute("loggedUsers");

        loggedUsers.clear();
        session.setAttribute("loggedUsers", loggedUsers);

        return "redirect:/index.jsp";
    }
}
