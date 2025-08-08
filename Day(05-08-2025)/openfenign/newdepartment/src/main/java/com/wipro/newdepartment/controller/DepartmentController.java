package com.wipro.newdepartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.newdepartment.entity.Department;

import com.wipro.newdepartment.services.DepartmentService;


@RestController
@RequestMapping("dept")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping
	void save(@RequestBody Department department) {
		System.out.println("new department Added");
		departmentService.save(department);
	}
	
	@GetMapping
	List<Department> findAll(){
		System.out.println("department List");
		return departmentService.findAll();
	}
	

}
