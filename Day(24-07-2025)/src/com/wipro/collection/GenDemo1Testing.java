package com.wipro.collection;

public class GenDemo1Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenDemo<String> demo1 = new GenDemo<String>();
		demo1.add("Vedanti");
		System.out.println(demo1.GetGenDemo());
		
		System.out.println("---------");
		GenDemo<Integer> demo2 = new GenDemo<Integer>();
		demo2.add(2);
		System.out.println(demo2.GetGenDemo());
	}
	

}
