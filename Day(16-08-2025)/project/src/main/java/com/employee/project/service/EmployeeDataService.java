package com.employee.project.service;

import java.util.List;

import com.employee.project.entity.EmployeeData;

public interface EmployeeDataService {
	
	 void save(EmployeeData employeeData);
	 
	 List<EmployeeData> findAll();
	 
	 EmployeeData findById(int employeeId);
	 
	void DeleteById(int id);

	void update(EmployeeData employeeData);
	 
	 

}
