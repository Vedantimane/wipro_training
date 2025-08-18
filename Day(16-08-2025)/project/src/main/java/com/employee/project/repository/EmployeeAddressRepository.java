package com.employee.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.project.entity.EmployeeAddress;
@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, Integer> {

}
