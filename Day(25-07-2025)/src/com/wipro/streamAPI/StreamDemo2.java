package com.wipro.streamAPI;

import java.util.Arrays;
import java.util.List;

public class StreamDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list =Arrays.asList(1,4,8,76,5,90,22,49);
		Long cnt =
		list.stream()
		.distinct()
		.filter(s->s%2==0)
		.count();
		System.out.println(cnt);

	}

}
