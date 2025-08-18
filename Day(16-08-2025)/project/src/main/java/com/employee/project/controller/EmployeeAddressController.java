package com.employee.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee.project.entity.EmployeeAddress;
import com.employee.project.service.EmployeeAddressService;

@RestController
@RequestMapping("/addresses")
public class EmployeeAddressController {

    @Autowired
    private EmployeeAddressService addressService;

    @PostMapping("/save/{employeeId}")
    public EmployeeAddress addAddress(@PathVariable int employeeId, @RequestBody EmployeeAddress address) {
        return addressService.addAddressToEmployee(employeeId, address);
    }

    @GetMapping
    public List<EmployeeAddress> getAllAddresses() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeAddress getAddressById(@PathVariable int id) {
        return addressService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable int id) {
        addressService.deleteById(id);
        return "Address deleted successfully";
    }

    @PostMapping("/save")
    public EmployeeAddress saveAddress(@RequestBody EmployeeAddress address) {
        return addressService.save(address);
    }
}
