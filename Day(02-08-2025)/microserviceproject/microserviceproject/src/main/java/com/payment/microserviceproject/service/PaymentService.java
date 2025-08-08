package com.payment.microserviceproject.service;

import java.util.List;

import com.payment.microserviceproject.entity.Payment;

public interface PaymentService {
	
	Payment save(Payment payment);
	
	List<Payment> findAll();
	
	Payment findById(int id);
	
	boolean deleteById(int id);

	boolean update(Payment payment);
	

	

}
