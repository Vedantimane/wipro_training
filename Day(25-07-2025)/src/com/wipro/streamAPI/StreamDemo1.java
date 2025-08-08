package com.wipro.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = Arrays.asList("vedanti","dilip","anisha","abc","anisha","dante");
		
//		Predicate<String> pre = (s)->s.length()<6;
//		Function<String,String> f = s->s.toUpperCase();
		
		
		List<String> output = 
		list.stream()
		.distinct()
		.filter(s->s.length()<6)
		.map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println();
	}

}
