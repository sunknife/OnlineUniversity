package autoleasing.controller.filter;

import autoleasing.model.entity.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        ServletContext context = servletRequest.getServletContext();
        //System.out.println(session.getAttribute("role"));
        //System.out.println(context.getAttribute("loggedUsers"));
        Role role = (Role) session.getAttribute("role");
        if (session.getAttribute("username") != null
                && session.getAttribute("password") != null
                    && role != null) {
            moveTo(request,response, role);
        } else  {
            moveTo(request,response, Role.GUEST);
            }



        filterChain.doFilter(servletRequest,servletResponse);
    }

    private void moveTo(HttpServletRequest request, HttpServletResponse response, final Role role) throws ServletException, IOException {
        if (role.equals(Role.ADMIN)) {
            request.getRequestDispatcher("/WEB-INF/admin/adminbase.jsp").forward(request,response);
        } else if (role.equals(Role.USER)) {
            request.getRequestDispatcher("/WEB-INF/user/userbase.jsp").forward(request,response);
        } else if (role.equals(Role.MANAGER)){
            request.getRequestDispatcher("/WEB-INF/manager/managerbase.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}