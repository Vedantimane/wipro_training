package com.wipro.exception;

public class NullStringException {

	
	public static void main(String[] args) {
		
		
		
		
		try{
			String word = "";
			System.out.println(word.toUpperCase());
		}
		catch(NullPointerException ex) {
			System.out.println("word can not be null");
		}
		
	}
}
