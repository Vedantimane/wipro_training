package com.booking.Uber.dto;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data

public class UberUser {
	
	
	int uberUserId;
	String uberId;
	String SourceLocation;
	String destinationLocation;
	boolean status;
}