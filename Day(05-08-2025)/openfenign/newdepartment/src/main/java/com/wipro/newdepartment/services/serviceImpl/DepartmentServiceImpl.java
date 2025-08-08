package com.wipro.newdepartment.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.newdepartment.entity.Department;
import com.wipro.newdepartment.repository.DepartmentRepository;
import com.wipro.newdepartment.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentRepository.save(department);

	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

}
