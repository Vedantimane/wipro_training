package com.wipro.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        List<Employee> employees = new ArrayList<>();

        
        employees.add(new Employee("E101", "amar", 30, 40000));
        employees.add(new Employee("E102", "bunty", 28, 72000));
        employees.add(new Employee("E103", "ciya", 35, 61000));
        employees.add(new Employee("E104", "dante", 40, 80000));


        System.out.println("by salary");
        Collections.sort(employees); 
        System.out.println(employees.toString());
        
        System.out.println("by name");
        Collections.sort(employees, new sortedByEmployeeName());
        System.out.println(employees.toString());

        System.out.println("by age");
        Collections.sort(employees, new SortedByEmployeeAge());
        System.out.println(employees.toString());
        
        System.out.println("by Id");
        Collections.sort(employees, new SortedByEmployeeId());
        System.out.println(employees.toString());


        

	}

}
