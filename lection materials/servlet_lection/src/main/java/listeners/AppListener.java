package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by eugen on 11/21/18.
 */
public class AppListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context initialized");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context destroyed");
    }
}
