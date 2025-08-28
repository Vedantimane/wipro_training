package com.backend.user_ms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.user_ms.dto.Token;
import com.backend.user_ms.entity.User;
import com.backend.user_ms.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userServie;
	
	@GetMapping
	List<User> findAll()
	{
		return userServie.findAll();
	}
	@GetMapping("/{id}")
	User findById(@PathVariable int id)
	{
		return userServie.findById(id);
	}
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable int id)
	{
		 userServie.deleteById(id);
	}
	 @PostMapping("/save")
	    public ResponseEntity<String> saveUser(@RequestBody User user) {
	        try {
	        	userServie.save(user);  // Calls your service method
	            return ResponseEntity.ok("✅ User registered successfully!");
	        } catch (Exception e) {
	            return ResponseEntity
	                    .badRequest()
	                    .body("❌ Error registering user: " + e.getMessage());
	        }
	    }
	
	@PutMapping
	void update(@RequestBody User user)
	{
		userServie.save(user);
		
	}
	
	@PostMapping("/login")
	Token login(@RequestBody User user)
	{
		
		
		return userServie.login(user);
		
	}

}