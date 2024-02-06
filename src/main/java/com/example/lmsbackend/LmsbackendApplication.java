package com.example.lmsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  // Enable Eureka Client
public class LmsbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsbackendApplication.class, args);
	}
}