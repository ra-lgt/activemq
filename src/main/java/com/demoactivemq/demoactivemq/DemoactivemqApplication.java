package com.demoactivemq.demoactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class DemoactivemqApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoactivemqApplication.class, args);
	}

}
