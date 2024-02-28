package com.demo.microservices.standardapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StandardApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandardApiServiceApplication.class, args);
	}

}
