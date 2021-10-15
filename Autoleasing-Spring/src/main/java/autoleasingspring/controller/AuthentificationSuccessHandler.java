package autoleasingspring.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthentificationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        String role = authentication.getAuthorities().toString();
        String targetUrl = request.getContextPath();
        if (role.contains("users:write")) {
            targetUrl = "admin";
        } else if (role.contains("users:read")) {
            targetUrl = "manager";
        } else if (role.contains("users:start")){
            targetUrl = "cabinet";
        }
        response.sendRedirect(targetUrl);
    }
}
