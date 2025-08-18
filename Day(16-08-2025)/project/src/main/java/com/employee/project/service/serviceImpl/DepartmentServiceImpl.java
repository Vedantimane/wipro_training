package com.employee.project.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.project.entity.Department;
import com.employee.project.repository.DepartmentRepository;
import com.employee.project.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

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

	@Override
	public Department findById(int departmentId) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(departmentId).orElse(null);
	}

	@Override
	public void deleteById(int departmentId) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(departmentId);
	}

   
}
