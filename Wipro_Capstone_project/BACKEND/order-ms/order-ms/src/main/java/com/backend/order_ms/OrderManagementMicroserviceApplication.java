package com.backend.order_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementMicroserviceApplication.class, args);
	}

}
