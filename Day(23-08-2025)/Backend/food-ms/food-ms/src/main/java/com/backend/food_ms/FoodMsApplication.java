package com.backend.food_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//with jwt
public class FoodMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodMsApplication.class, args);
	}

}
