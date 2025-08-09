package com.booking.Uberuser.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="uber_user")
public class UberUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int uberUserId;
	
	String uberId;
	String SourceLocation;
	String destinationLocation;
	boolean status;
	

}
