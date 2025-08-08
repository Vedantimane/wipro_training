package com.wipro.annonymous.test;

public class GreetLambdaFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GreetInterface greet = ()-> {
			System.out.println("Help Lambda");
		};
		greet.sayHello();
	}
	

}
