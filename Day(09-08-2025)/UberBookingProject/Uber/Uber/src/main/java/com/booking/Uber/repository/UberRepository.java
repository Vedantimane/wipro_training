package com.booking.Uber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.Uber.entity.Uber;

@Repository
public interface UberRepository extends JpaRepository<Uber, Integer> {
	
	Uber findByUberId(String uberId);

}
