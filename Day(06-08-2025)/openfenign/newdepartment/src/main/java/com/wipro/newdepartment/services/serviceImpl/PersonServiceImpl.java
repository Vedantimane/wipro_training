package com.wipro.newdepartment.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.newdepartment.entity.Person;
import com.wipro.newdepartment.repository.PersonRepository;
import com.wipro.newdepartment.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub

		personRepository.save(person);
	}

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

}
