package com.wipro.newdepartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.newdepartment.entity.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
