package com.documents;

import com.documents.dao.impl.DBConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class ApplicationConfig {

    @Bean
    Connection connection() {
        Connection connection = DBConnection.getInstance().getConnection();
        return connection;
    }

}
