package com.employee.project.service;

import java.util.List;

import com.employee.project.entity.Department;


public interface DepartmentService {
	
	void save(Department department);
    
    List<Department> findAll();
    
    Department findById(int departmentId);
    
    void deleteById(int departmentId);

}
