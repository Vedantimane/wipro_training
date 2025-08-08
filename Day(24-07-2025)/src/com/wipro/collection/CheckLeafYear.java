package com.wipro.collection;

import java.time.LocalDate;

public class CheckLeafYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate date1 = LocalDate.of(1700, 4, 12);
		boolean result=checkingLeafYear(date1);
		System.out.println(result);
	}

	public static boolean checkingLeafYear(LocalDate date) {
		int year = date.getYear();
		
		if(year %400==0) {
			return true;
		}else {
			return false;
		}
}
}
