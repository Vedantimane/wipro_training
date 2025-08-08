package com.wipro.newdepartment.services;

import java.util.List;

import com.wipro.newdepartment.entity.Employee;

public interface EmployeeService {
	
	void save(Employee employee);
	
	List<Employee> findAll();

}
