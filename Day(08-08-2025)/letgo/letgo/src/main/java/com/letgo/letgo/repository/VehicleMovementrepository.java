package com.letgo.letgo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.letgo.letgo.entity.VehicleMovement;

@Repository
public interface VehicleMovementrepository extends JpaRepository<VehicleMovement, Integer> {

}
