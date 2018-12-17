import dao.impl.DBConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.sql.Connection;

@ComponentScan(basePackages = "services,dao,servlets")
public class ApplicationConfig {

    @Bean
    Connection connection() {
        Connection connection = DBConnection.getInstance().getConnection();
        return connection;
    }

}
