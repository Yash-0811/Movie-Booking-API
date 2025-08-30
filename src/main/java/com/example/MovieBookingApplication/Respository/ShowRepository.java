package com.example.MovieBookingApplication.Respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MovieBookingApplication.Entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long>{
	
	Optional<List<Show>> findByMovieId(Long movieid);
	Optional<List<Show>> findByTheaterId(Long theaterid);
}	
