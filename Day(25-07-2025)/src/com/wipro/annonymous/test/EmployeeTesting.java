package com.wipro.annonymous.test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





public class EmployeeTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
List<Employee> employees = new ArrayList<>();

        
        employees.add(new Employee("E101", "amar", 30, 40000));
        employees.add(new Employee("E102", "xyz", 28, 72000));
        employees.add(new Employee("E103", "ciya", 35, 61000));
        employees.add(new Employee("E104", "dante", 40, 80000));
	        
	        Comparator<Employee> bynameComparator = (o1, o2) ->{
	        	String name1 = o1.getEmpName();
	        	String name2 = o2.getEmpName();
				return name1.compareTo(name2);
	        	
	        };
	        
	        Comparator<Employee> bysalaryComparator = (o1, o2) ->{
	        	double salary1 = o1.getEmpSalary();
	        	double salary2 = o2.getEmpSalary();
	        	 return Double.compare(salary1, salary2); 
	        	
	        };
	        
	        Collections.sort(employees, bynameComparator);
	        System.out.println(employees.toString());

	}

}
