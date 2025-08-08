package com.wipro.weathermanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
	
	 @GetMapping("/weather")
	    public String getWeather(@RequestParam String city, @RequestParam String day) {
	        
	        return "Weather in " + city + " for " + day + " is cloudy.";
	    }
	 
	 @GetMapping("/tocentigrade/{value}")
	 public String tocentigrate(@PathVariable int value) {
		 double celsisus = (value-32) *5/9;
		 return "celsius value of "+value+" is "+celsisus;
		 
		 
	 }

}
