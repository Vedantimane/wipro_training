package com.wipro.newdepartment.services;

import java.util.List;

import com.wipro.newdepartment.entity.Person;

public interface PersonService {
	
	void save(Person person);

	List<Person> findAll();

}
