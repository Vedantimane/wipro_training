package com.booking.Uberuser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.Uberuser.entity.UberUser;

@Repository
public interface UberUserRepository extends JpaRepository<UberUser, Integer> {
	
//	Optional<UberUser> findByUberId(String uberId);

}
