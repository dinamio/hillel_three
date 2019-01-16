package controller.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;
@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                servletContextEvent.getServletContext());

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
