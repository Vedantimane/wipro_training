package com.payment.microserviceproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name= "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int paymentId;
	
	String paymentMode;
	
	Double paymentAmount;
	
	String paymentDescription;
	
	boolean paymentStatus;
	
	int orderId;
	
}
