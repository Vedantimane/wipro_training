package com.discory.discoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class DiscoryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoryserviceApplication.class, args);
	}

}
