package com.car.cardemo.service;

import java.util.List;

import com.car.cardemo.entity.Car;

public interface CarService {

	 Car save(Car car);
	    List<Car> findAll();
	    Car findById(Long id);
	    Car update(Long id, Car car);
	    void deleteById(Long id);
}
