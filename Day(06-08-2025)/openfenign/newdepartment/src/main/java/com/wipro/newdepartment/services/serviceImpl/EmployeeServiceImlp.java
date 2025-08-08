package com.wipro.newdepartment.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.newdepartment.entity.Employee;
import com.wipro.newdepartment.repository.EmployeeRepository;
import com.wipro.newdepartment.services.EmployeeService;


@Service
public class EmployeeServiceImlp implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public void save(Employee employee) {
	    employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
	    return employeeRepository.findAll();
	}


}
