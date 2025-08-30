package com.example.MovieBookingApplication.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ShowDTO {

	private LocalDateTime showTime;
	private Double price;
	private Long movieId;
	private Long theaterId;

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}

	public ShowDTO(LocalDateTime showTime, Double price, Long movieId, Long theaterId) {
		super();
		this.showTime = showTime;
		this.price = price;
		this.movieId = movieId;
		this.theaterId = theaterId;
	}

	public ShowDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
