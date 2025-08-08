package com.wipro.newdepartment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.newdepartment.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
