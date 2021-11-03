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
        boolean isGuestPath = guestPageList.contains(loginRequest);

        if (loggedIn || isGuestPath) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            response.sendRedirect(loginURI);
        }





    }


    @Override
    public void destroy() {

    }
}
