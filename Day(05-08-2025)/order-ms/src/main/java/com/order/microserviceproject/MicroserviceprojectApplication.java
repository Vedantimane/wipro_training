package com.order.microserviceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MicroserviceprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceprojectApplication.class, args);
	}

}

//Ex4: Setup Prometheus server and enable Prometheus metrics collection from order ms