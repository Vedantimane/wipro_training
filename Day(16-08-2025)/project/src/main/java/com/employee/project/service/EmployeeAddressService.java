package com.employee.project.service;

import java.util.List;

import com.employee.project.entity.EmployeeAddress;

public interface EmployeeAddressService {
	
	  EmployeeAddress save(EmployeeAddress employeeAddress);
	    
	    List<EmployeeAddress> findAll();
	    
	    EmployeeAddress findById(int addressId);
	    
	    void deleteById(int addressId);
	    
	    EmployeeAddress addAddressToEmployee(int employeeId, EmployeeAddress address); // new method

}
