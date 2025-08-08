package com.wipro.springmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springmvc.repository.CarRepository;

@Service
public class CarServiceImplimentation implements CarService{

	@Autowired
	CarRepository carRepository;
	@Override
	public List<String> getCarList() {
		// TODO Auto-generated method stub
		 return carRepository.getCarList();
	}
	
	

}
