package com.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = "com.vm")
@EnableAutoConfiguration  // Sprint Boot Auto Configuration
@ComponentScan(basePackages = "com.vm")
@Configuration
public class SpringConsoleApplication extends SpringBootServletInitializer {

    private static final Class<SpringConsoleApplication> applicationClass = SpringConsoleApplication.class;
    
    public static void main(String[] args) {
        //SpringApplication.run(SpringConsoleApplication.class, args);
        SpringApplication application = new SpringApplication(SpringConsoleApplication.class);
        //application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
        System.out.println("Vinod Spring Boot Test");
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
}
