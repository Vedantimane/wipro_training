package com.wipro.collection;

import java.util.Comparator;

public class SortedByEmployeeAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
        return Integer.compare(o1.getEmpAge(), o2.getEmpAge()); 
	}

}
