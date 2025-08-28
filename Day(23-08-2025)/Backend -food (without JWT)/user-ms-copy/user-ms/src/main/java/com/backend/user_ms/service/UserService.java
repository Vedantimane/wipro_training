package com.backend.user_ms.service;

import java.util.List;
import java.util.Optional;

import com.backend.user_ms.entity.User;

public interface UserService {
	
	User save(User user);
	
	List<User> findAll();
	
	Optional<User> getById(int id);
	
	User update(User user);

	void deleteById(int id);

	User findByEmailAndPassword(String userEmail, String userPassword);
	

}
