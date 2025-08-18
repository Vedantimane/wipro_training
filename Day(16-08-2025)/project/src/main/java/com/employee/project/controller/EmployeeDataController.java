package com.employee.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee.project.entity.EmployeeData;
import com.employee.project.service.EmployeeDataService;

@RestController
@RequestMapping("/employees")
public class EmployeeDataController {

    @Autowired
    private EmployeeDataService employeeDataService;

    @PostMapping()
    public String saveEmployee(@RequestBody EmployeeData employee) {
        employeeDataService.save(employee);
        return "Employee saved successfully";
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable("id") int employeeId, @RequestBody EmployeeData employee) {
        employee.setEmployeeId(employeeId);
        
        employeeDataService.update(employee);
        
        return "Employee updated or created successfully";
    }


    @GetMapping
    public List<EmployeeData> getAllEmployees() {
        return employeeDataService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeData getEmployeeById(@PathVariable int id) {
        return employeeDataService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeDataService.DeleteById(id);
        return "Employee deleted successfully";
    }
}
