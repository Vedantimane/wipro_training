package com.wipro.springmvc.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {
	
	public List<String> getCarList(){
		List<String> carlist= Arrays.asList("BMW","Audi","Hyundai","Land Rover","Rolls-Royce");
		return carlist;
	}

}
