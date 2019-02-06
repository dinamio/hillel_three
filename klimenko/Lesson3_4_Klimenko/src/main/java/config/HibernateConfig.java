package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
<<<<<<< HEAD


import org.springframework.jdbc.datasource.DriverManagerDataSource;
=======
>>>>>>> 60cac7ff53855449b2d79895fe9cc70f360cc243
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;

import java.util.Properties;


@Configuration
@EnableTransactionManagement
@PropertySource(value = {
        "classpath:application.properties"
})
public class HibernateConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties props = new Properties();

        props.put("hibernate.connection.driver_class", env.getProperty("jdbc.driver"));
        props.put("hibernate.connection.url", env.getProperty("jdbc.url"));
        props.put("hibernate.connection.username", env.getProperty("jdbc.username"));
        props.put("hibernate.connection.password", env.getProperty("jdbc.password"));
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.put("hibernate.format_sq", env.getProperty("hibernate.hbm2ddl.auto"));

        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("entity");

        return factoryBean;
    }
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

}
