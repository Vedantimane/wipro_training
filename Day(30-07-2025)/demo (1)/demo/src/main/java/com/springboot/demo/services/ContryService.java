package com.springboot.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.repository.ContryRepository;

@Service
public class ContryService {
	
	@Autowired
	ContryRepository contryRepository;
	public List<String> getContryList(){
		 return contryRepository.getContryList();
//		return null;
//		
	}
	

}
