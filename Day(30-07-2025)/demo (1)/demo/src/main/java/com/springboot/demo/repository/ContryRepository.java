package com.springboot.demo.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ContryRepository {
	public List<String> getContryList(){
		List<String> contries = Arrays.asList("India","Japan","France","korea");
		return contries;
		
	}

}
