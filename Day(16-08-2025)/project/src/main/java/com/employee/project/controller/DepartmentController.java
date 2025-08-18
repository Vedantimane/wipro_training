package com.employee.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee.project.entity.Department;
import com.employee.project.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    
    @PostMapping
    public String createDepartment(@RequestBody Department department) {
        departmentService.save(department);
        return "Department created successfully";
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        return departmentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable int id) {
        departmentService.deleteById(id);
        return "Department deleted successfully";
    }
}
