package com.wipro.newdepartment.services;

import java.util.List;

import com.wipro.newdepartment.entity.Genre;

public interface GenreService {
	
	void save(Genre genre);
	List<Genre> findAll();
	

}
