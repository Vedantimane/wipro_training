package com.wipro.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> list = new ArrayList();
		
		list.add(10);
		list.add(11);
		list.add(3);
		list.add(23);
		list.add(3);
		
		Set<Integer> set = new HashSet(list);
		
		System.out.println(set);
		
	}

}
