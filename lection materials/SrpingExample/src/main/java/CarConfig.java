import model.Model;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by eugen on 12/12/18.
 */
@ComponentScan(basePackages = "service,dao")
public class CarConfig {

    @Bean
    Model teslaModel() {
        Model model = new Model();
        model.setName("TESLA");
        model.setDoors(3);
        return model;
    }

    @Bean
    Model teslaModel1() {
        Model model = new Model();
        model.setName("Tesla");
        model.setDoors(3);
        return model;
    }

    /*@Bean
    ModelService modelService() {
        return new ModelService();
    }

    @Bean
    ModelDao jdbcModelDao() {
        return new JDBCModelDao();
    }

    @Bean
    ModelDao hibernateModelDao() {
        return new HibernateModelDao();
    }*/
}
