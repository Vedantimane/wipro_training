package com.backend.user_ms.service;

import java.util.List;

import com.backend.user_ms.dto.Token;
import com.backend.user_ms.entity.User;

public interface UserService {
	
	List<User> findAll();
	User findById(int id);
	void save(User user);
	void deleteById(int id);
	Token login(User user);

}