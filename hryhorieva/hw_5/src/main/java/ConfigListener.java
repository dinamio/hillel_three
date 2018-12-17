import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;

public class ConfigListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        servletContextEvent.getServletContext().setAttribute("applicationContext", ac);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
