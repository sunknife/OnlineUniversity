package autoleasing.controller.filter;

import autoleasing.model.entity.Role;
import autoleasing.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthFilter implements Filter {

    private List<String> guestPageList = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            guestPageList.add("/login");
            guestPageList.add("/");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;



        HttpSession session = request.getSession(false);
        String loginURI ="/login";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        String loginRequest = request.getRequestURI();
        System.out.println(loginRequest);
        boolean isGuestPath = guestPageList.contains(loginRequest);

        if (loggedIn || isGuestPath) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            response.sendRedirect(loginURI);
        }





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
