package listeners;

import dao.impl.DBConnection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionListener implements ServletContextListener {
    Connection connection;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.connection = DBConnection.getInstance().getConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
