package com.wipro.newdepartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.newdepartment.entity.Genre;
import com.wipro.newdepartment.services.GenreService;

@RestController
@RequestMapping("genre")
public class GenreController {
	
	@Autowired
	GenreService genreService;
	
	@PostMapping
	void save(@RequestBody Genre genre)
	{
		  genreService.save(genre);
	}
	
	@GetMapping
	List<Genre> findAll()
	{
		return genreService.findAll();
	}

}
