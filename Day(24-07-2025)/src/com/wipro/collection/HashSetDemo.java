package com.wipro.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Integer> set = new HashSet<>();
		
		set.add(34);
		set.add(2);
		set.add(1);
		set.add(24);
		
		
		System.out.println(set);
		set.remove(24);
		System.out.println(set);
	}
	
	

}
