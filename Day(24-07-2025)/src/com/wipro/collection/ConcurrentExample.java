package com.wipro.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



        Employee em1=new Employee("E101", "amar", 30, 40000);
        Employee em2=new Employee("E102", "bunty", 28, 72000);
        Employee em3=new Employee("E103", "ciya", 35, 61000);
        Employee em4=new Employee("E104", "dante", 40, 90000);
        List<Employee> employees= new CopyOnWriteArrayList<>();
        employees.add(em1);
        employees.add(em2);
        employees.add(em3);
        employees.add(em4);
        System.out.println("before removing");
        System.out.println(employees.toString());
       for(Employee employee : employees) {
    	   if(employee.getEmpSalary()>80000) {
    		   employees.remove(employee);
    	   } 
       }
       System.out.println("after rmoving");
	   System.out.println(employees.toString());
	}

}
