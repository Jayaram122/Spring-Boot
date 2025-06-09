package com.demo.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.mvc.entity.MovieDetails;

@Repository
public interface MovieRepo extends JpaRepository<MovieDetails, Long> {

	public MovieDetails findByMovieName(String movieName);
 
}
