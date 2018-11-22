package app.servlets;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListnerServlet implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //se.getSession().setAttribute("", );
    }
}
