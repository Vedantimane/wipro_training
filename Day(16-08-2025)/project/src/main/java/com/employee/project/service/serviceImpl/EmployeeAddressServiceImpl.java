package com.employee.project.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.project.entity.EmployeeAddress;
import com.employee.project.entity.EmployeeData;
import com.employee.project.repository.EmployeeAddressRepository;
import com.employee.project.repository.EmployeeDataRepository;
import com.employee.project.service.EmployeeAddressService;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

    @Autowired
    private EmployeeAddressRepository employeeAddressRepository;

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress) {
      
        return employeeAddressRepository.save(employeeAddress);
    }

    @Override
    public List<EmployeeAddress> findAll() {
        return employeeAddressRepository.findAll();
    }

    @Override
    public EmployeeAddress findById(int addressId) {
        return employeeAddressRepository.findById(addressId).orElse(null);
    }

    @Override
    public void deleteById(int addressId) {
        employeeAddressRepository.deleteById(addressId);
    }

    @Override
    public EmployeeAddress addAddressToEmployee(int employeeId, EmployeeAddress address) {
        EmployeeData employee = employeeDataRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id: " + employeeId));

        address.setEmployee(employee);
        employee.getAddresses().add(address);

        return employeeAddressRepository.save(address);
    }
}
