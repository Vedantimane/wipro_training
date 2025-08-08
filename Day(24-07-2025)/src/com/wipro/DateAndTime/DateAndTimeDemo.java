package com.wipro.DateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateAndTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//
//		LocalDate demo1 = LocalDate.of(2023, Month.NOVEMBER, 1);
//		System.out.println(demo1);
//		
//		DateTimeFormatter demo2 = DateTimeFormatter.ofPattern("dd-MM-YYYY");
//		
//		System.out.println(demo1.format(demo2));
		
//		LocalDate date1 = LocalDate.of(2002, 4, 13);
//		System.out.println(getAge(date1));
		
		LocalDate date1 = LocalDate.of(2004, 4, 12);
		boolean result=checkingLeafYear(date1);
		System.out.println(result);
//		LocalDate date2 = LocalDate.of(2004, 6, 5); 
//		String str =differnce(date1, date2);
//		System.out.println(str);
		
	}

	public static int getAge(LocalDate date) {
		int year =date.getYear();
		int currentyear = LocalDate.now().getYear();
		return currentyear-year;
		
	}
	
	public static String differnce(LocalDate date1, LocalDate date2) {
		
		int monthdiff = date1.getMonthValue() - date2.getMonthValue();
		Math.abs(monthdiff);
		int daydiff = date1.getDayOfMonth() - date2.getDayOfMonth();
		Math.abs(daydiff);
		int yearDiff = date1.getYear() - date2.getYear();
		Math.abs(yearDiff);
		return "the Difference in day: "+daydiff+" month: "+monthdiff+" year: "+yearDiff;
		
	}
	
	public static boolean checkingLeafYear(LocalDate date) {
		int year = date.getYear();
		
		if(year %4==0) {
			return true;
		}else {
			return false;
		}
		
	}
}
