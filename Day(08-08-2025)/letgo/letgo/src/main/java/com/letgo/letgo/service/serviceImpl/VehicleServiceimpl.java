package com.letgo.letgo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.letgo.letgo.entity.VehicleMovement;
import com.letgo.letgo.repository.VehicleMovementrepository;
import com.letgo.letgo.service.VehicleService;

public class VehicleServiceimpl implements VehicleService {
	
	 @Autowired
	    private VehicleMovementrepository vehicleMovementRepository;

	 @Override
	public VehicleMovement save(VehicleMovement movement) {
		// TODO Auto-generated method stub
		return vehicleMovementRepository.save(movement);
	}

}
