package com.user.user_ms.service;

import java.util.List;

import com.user.user_ms.entity.User;

public interface UserService {
	
	User save(User user);
	
	List<User> findAll();
	
	User findById(int id);
	
	boolean deleteById(int id);

	boolean update(User user);
	
	

}
