package com.wipro.newdepartment.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.newdepartment.entity.Genre;
import com.wipro.newdepartment.repository.GenreRepository;
import com.wipro.newdepartment.repository.MovieRepository;
import com.wipro.newdepartment.services.GenreService;

@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	MovieRepository movieRepository;

	  @Override
	    public void save(Genre genre) {
	        // Saving Genre will also save Movies because of CascadeType.ALL
	        genreRepository.save(genre);
	    }

	    @Override
	    public List<Genre> findAll() {
	        return genreRepository.findAll();
	    }

}
