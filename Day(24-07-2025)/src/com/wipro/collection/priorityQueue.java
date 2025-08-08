package com.wipro.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class priorityQueue {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		Queue<Integer> line = new PriorityQueue<>(Collections.reverseOrder());
		line.add(12);
		line.add(23);
		line.add(67);
		line.add(50);
		
		
		System.out.println(line);
		line.add(56);
		System.out.println(line);
		
		
		
	}

}
