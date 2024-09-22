package ru.skilllbox.diplom.group40.social.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


/**
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@Profile ("client_app_profile_name")
public class ClientAppConfiguration {
    //it can be left blank
}
 */


/**
@SpringBootApplication
public class SomeApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SomeApplication.class);
    }
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SomeApplication.class);
    }
}*/