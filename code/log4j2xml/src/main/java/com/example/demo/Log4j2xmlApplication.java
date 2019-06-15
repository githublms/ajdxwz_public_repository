package com.example.demo;

import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages = { "com.example.demo" })
public class Log4j2xmlApplication {
	
	private String bootstrap;

    public String getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(String bootstrap) {
        this.bootstrap = bootstrap;
    }

	public static void main(String[] args) {

        SpringApplication app = new SpringApplication(Log4j2xmlApplication.class);
        Set<ApplicationListener<?>> ls = app.getListeners();
        ApplicationStartedEventListener asel = new ApplicationStartedEventListener();
        app.addListeners(asel);
        app.run(args);
//		SpringApplication.run(Log4j2xmlApplication.class, args);
	}

}
