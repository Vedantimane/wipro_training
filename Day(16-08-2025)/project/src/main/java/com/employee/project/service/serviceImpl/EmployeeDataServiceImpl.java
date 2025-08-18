package com.employee.project.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.project.entity.Department;
import com.employee.project.entity.EmployeeData;
import com.employee.project.repository.DepartmentRepository;
import com.employee.project.repository.EmployeeDataRepository;
import com.employee.project.service.EmployeeDataService;

@Service
public class EmployeeDataServiceImpl implements EmployeeDataService {

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void save(EmployeeData employeeData) {
        if (employeeData.getDepartmentId() != null) {
            Department dept = departmentRepository.findById(employeeData.getDepartmentId())
                    .orElse(null);
            employeeData.setDepartment(dept);
        }
        employeeDataRepository.save(employeeData);
    }

  
    @Override
    public void update(EmployeeData employeeData) {
        if (employeeData.getEmployeeId() != 0 &&
            employeeDataRepository.existsById(employeeData.getEmployeeId())) {

            EmployeeData existing = employeeDataRepository.findById(employeeData.getEmployeeId()).get();
            existing.setEmployeeName(employeeData.getEmployeeName());
            existing.setEmployeeEmail(employeeData.getEmployeeEmail());
            employeeDataRepository.save(existing);

        } else {         
            save(employeeData);
        }
    }

    @Override
    public List<EmployeeData> findAll() {
        return employeeDataRepository.findAll();
    }

    @Override
    public EmployeeData findById(int employeeId) {
        return employeeDataRepository.findById(employeeId).orElse(null);
    }

    @Override
    public void DeleteById(int employeeId) {
        employeeDataRepository.deleteById(employeeId);
    }
}
