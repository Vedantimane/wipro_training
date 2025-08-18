package com.employee.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.project.entity.EmployeeData;

@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeData, Integer> {

}
