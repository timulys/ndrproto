package com.kglory.signservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // Eureka Client
public class SignServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignServiceApplication.class, args);
	}

}
