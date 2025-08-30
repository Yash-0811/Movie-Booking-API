package com.example.MovieBookingApplication.Respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MovieBookingApplication.Entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	  Optional<List<Movie>> findByGenre(String genre);
	  Optional<List<Movie>> findByLanguage(String language);
	  Optional<Movie> findByName(String title);
}
