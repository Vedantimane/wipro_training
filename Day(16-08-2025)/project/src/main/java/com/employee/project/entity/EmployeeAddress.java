package com.employee.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EmployeeAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference(value = "employee-address")
    private EmployeeData employee;
}
