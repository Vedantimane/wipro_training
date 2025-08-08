package com.wipro.collection;

import java.util.ArrayList;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		System.out.println("adding element "+list);
		list.remove(2);
		System.out.println("after removing element "+list);
		list.addLast(60);
		System.out.println("adding element in last "+list);
	}

}
