package com.fsl.springbootwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.fsl.springbootwebsocket")
public class SpringbootWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebsocketApplication.class, args);
	}

}
