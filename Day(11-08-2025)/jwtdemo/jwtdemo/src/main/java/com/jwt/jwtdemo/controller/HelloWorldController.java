package com.jwt.jwtdemo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello "+name+"!!";
	}
	
	@RequestMapping("newhello")
	public String helloWorldNew(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello -New "+name+"!!";
	}
	
	 @GetMapping("/getCurrentTime")
	    public String getCurrentTime() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String now = LocalDateTime.now().format(formatter);
	        return "The current time is " + now;
	    }
}