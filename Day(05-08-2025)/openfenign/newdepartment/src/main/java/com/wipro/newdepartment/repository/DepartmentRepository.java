package com.wipro.newdepartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.newdepartment.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
