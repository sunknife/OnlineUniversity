package autoleasing.controller;

import autoleasing.controller.command.*;
import autoleasing.model.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig) {
        servletConfig.getServletContext().setAttribute("loggedUsers", new HashSet<String>());

        commands.put("/login", new LoginCommand(new UserService()));
        commands.put("/logout", new LogoutCommand());
        commands.put("/admin", new AdminBaseCommand());
        commands.put("/admin/ban" ,new AdminBanUserCommand(new UserService()));
        commands.put("/admin/unblock", new AdminUnblockUserCommand(new UserService()));
        commands.put("/admin/save_manager", new AdminSaveManagerCommand(new UserService()));
        commands.put("/admin/add_manager", new AdminAddManagerCommand());
        commands.put("/manager", new ManagerBaseCommand());
        commands.put("/error", new ErrorCommand());
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

        processRequest(httpServletRequest,httpServletResponse);

        //httpServletResponse.getWriter().println("Hello from servlet");
        //httpServletResponse.getWriter().println("Привіт");
    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {

        processRequest(httpServletRequest,httpServletResponse);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getRequestURI();
        System.out.println(path);
        Command command = commands.getOrDefault(path, (r)->"/index.jsp");
        System.out.println(command.getClass().getName());
        String page = command.execute(request);
        System.out.println(page);
        if (page.contains("redirect:")) {
            //request.getRequestDispatcher(page.replace("redirect:","")).forward(request,response);
            response.sendRedirect(page.replace("redirect:",""));
        } else {
            request.getRequestDispatcher(page).forward(request,response);
        }
    }

}
