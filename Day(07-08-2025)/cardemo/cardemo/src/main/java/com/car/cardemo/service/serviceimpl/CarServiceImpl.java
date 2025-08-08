package com.car.cardemo.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.cardemo.entity.Car;
import com.car.cardemo.repository.CarRepository;
import com.car.cardemo.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	
	 @Autowired
	    private CarRepository carRepository;

	@Override
	public Car save(Car car) {
		// TODO Auto-generated method stub
		  return carRepository.save(car);
	}

	@Override
	public List<Car> findAll() {
		// TODO Auto-generated method stub
		  return carRepository.findAll();
	}

	@Override
	public Car findById(Long id) {
		// TODO Auto-generated method stub
		 return carRepository.findById(id).orElse(null);
	}

	@Override
    public Car update(Long id, Car updatedCar) {
		// TODO Auto-generated method stub
        Car car = findById(id);
        if (car != null) {
            car.setMake(updatedCar.getMake());
            car.setRegistrationDetail(updatedCar.getRegistrationDetail());
            return carRepository.save(car);
        }
        return null;
    }

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		  carRepository.deleteById(id);
	}

}
