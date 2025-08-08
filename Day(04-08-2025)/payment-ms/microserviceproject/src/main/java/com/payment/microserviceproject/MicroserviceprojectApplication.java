package com.payment.microserviceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceprojectApplication.class, args);
	}

}
