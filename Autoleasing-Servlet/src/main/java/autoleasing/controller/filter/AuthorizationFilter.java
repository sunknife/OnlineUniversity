package autoleasing.controller.filter;

import autoleasing.model.entity.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthorizationFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        Role role = (Role) session.getAttribute("role");

        String path = request.getRequestURI();

        if (role != null) {
            boolean hasAdminPath = path.contains("admin");
            boolean hasUserPath = path.contains("user");
            boolean hasManagerPath = path.contains("manager");

            if (role.equals(Role.ADMIN) && hasAdminPath || role.equals(Role.MANAGER) && hasManagerPath || role.equals(Role.USER) && hasUserPath || path.contains("/logout")) {
                filterChain.doFilter(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request,response);
            }
        } else {
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
