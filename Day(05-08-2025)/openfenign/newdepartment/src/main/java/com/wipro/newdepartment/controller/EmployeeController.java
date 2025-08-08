package com.wipro.newdepartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.newdepartment.entity.Employee;
import com.wipro.newdepartment.services.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	void save(Employee employee) {
		System.out.println("new Employee Added");
		employeeService.save(employee);
	}
	
	@GetMapping
	List<Employee> findAll(){
		System.out.println("Employee List");
		return employeeService.findAll();
	}
	
	

}
