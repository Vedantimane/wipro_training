//package com.wipro.annonymous.test;
//
//import java.util.ArrayList;
//import java.util.function.Supplier;
//
//public class Suppliertest {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Supplier<String> day = ()->{
//			ArrayList<String> days = new ArrayList();
//			days.add("Mon");
//			days.add("Tue");
//			days.add("Wed");
//			days.add("Thrus");
//			days.add("Fri");
//			days.add("Satur");
//			days.add("Sun");
//			
//			String currentday = "Wed";
//			int currentdayIndex= days.indexOf(currentday);
//			
//			String nextday =days.get(currentdayIndex+1);
//			if(nextday>6) {
//				return	nextday=0;
//			}else {
//			return nextday;
//			}
// 
//			
//			
//		};
//		 System.out.println(day.get());
//	}
//
//}
