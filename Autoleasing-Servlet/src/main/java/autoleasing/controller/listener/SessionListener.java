package autoleasing.controller.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HashSet<String> loggedUsers = (HashSet<String>) httpSessionEvent.
                getSession().getServletContext().
                getAttribute("loggedUsers");
        String username = (String) httpSessionEvent.getSession().getServletContext().getAttribute("username");
        loggedUsers.remove(username);
        httpSessionEvent.getSession().setAttribute("loggedUsers", loggedUsers);
    }
}
