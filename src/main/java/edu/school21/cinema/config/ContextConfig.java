package edu.school21.cinema.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import edu.school21.cinema.mappers.PasswordDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@ComponentScan("edu.school21.cinema")
@PropertySource("classpath:application.properties")
public class ContextConfig {

    @Value("${app.datasource.url}")
    public String datasourceUrl;
    @Value("${app.datasource.username}")
    public String datasourceUsername;
    @Value("${app.datasource.password}")
    public String datasourcePassword;
    @Value("${app.datasource.driverclassname}")
    public String driverClassName;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ObjectMapper objectMapper(PasswordDeserializer passwordDeserializer){
//        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//        builder.deserializers(passwordDeserializer);
//        return builder.build();
////        return new ObjectMapper();

//        SimpleModule module = new SimpleModule();
//        module.addDeserializer(String.class, passwordDeserializer);
        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(module);
        return mapper;
    }
}
