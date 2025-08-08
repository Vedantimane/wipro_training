package com.security.securitydemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	 @GetMapping("/")
	    public String home() {
	        return "Welcome, you are logged in!";
	    }
	
	 @GetMapping("/greet")
	    public String greet() {
	        return "Hello! greet.";
	    }

	    @GetMapping("/hello")
	    public String secure() {
	        return "hello you logged in";
	    }
}
