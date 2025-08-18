package com.employee.project.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    private String employeeName;

    private String employeeEmail;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer departmentId;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference(value = "department-employee")
    private Department department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "employee-address")
    private List<EmployeeAddress> addresses = new ArrayList<>();
}
