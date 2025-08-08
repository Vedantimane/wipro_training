package com.wipro.newdepartment.services;

import java.util.List;

import com.wipro.newdepartment.entity.Department;


public interface DepartmentService {
	
 void save(Department department);
	
	List<Department> findAll();

}
