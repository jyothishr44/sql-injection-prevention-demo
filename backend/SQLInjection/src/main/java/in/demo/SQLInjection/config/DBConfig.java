package in.demo.SQLInjection.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

@Configuration
public class DBConfig
{
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, username, password);
    }
}
