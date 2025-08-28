package com.backend.user_ms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;


	@PostMapping("/register")
	public User save(@RequestBody User user) {
	
		return userService.save(user);
	}


	@GetMapping
	public List<User> findAll() {
		
		return userService.findAll();
	}


	 @GetMapping("/{id}")
	    public User getById(@PathVariable int id) {
	        Optional<User> userOpt = userService.getById(id);
	        return userOpt.orElse(null);
	    }

	 @PutMapping
	 public User update(@RequestBody User user) {
	     return userService.update(user);
	 }


	 @DeleteMapping("/{id}")
	 public void deleteById(@PathVariable int id) {
	     userService.deleteById(id);
	 }


	 @PostMapping("/login")
	 public Token login(@RequestBody User user) {
	     return userService.login(user);
	 }


	

}

