package com.wipro.annonymous.test;

public class multiplyLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MultipyInterface one = (a,b)->  a*b;
		
		System.out.println(one.multiply(4,5));
		
		MultipyInterface two = (c,d) -> c*d;
		
		System.out.println(two.multiply(5,5));
	}
	

}
