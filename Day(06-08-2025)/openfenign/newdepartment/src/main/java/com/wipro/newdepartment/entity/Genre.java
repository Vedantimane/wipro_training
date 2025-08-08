package com.wipro.newdepartment.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="genre_id")
	int genreId;
	
	@Column(name="genre_type")
	String genreType;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	    name = "movie_genre",
	    joinColumns = @JoinColumn(name = "genre_id"),
	    inverseJoinColumns = @JoinColumn(name = "movie_id")
	)
	
	Set<Movie> movie;

}
