package edu.school21.cinema;

import edu.school21.cinema.config.CommonConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CommonConfig.class);
}
