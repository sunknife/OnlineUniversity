package autoleasing.controller.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class InternationalizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if (httpServletRequest.getSession().getAttribute("lang") == null) {
            httpServletRequest.getSession().setAttribute("lang", "ua");
        } else if (httpServletRequest.getParameter("lang") != null) {
            httpServletRequest.getSession().setAttribute("lang", httpServletRequest.getParameter("lang"));
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
