package com.example.MovieBookingApplication.Entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "shows")
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime showTime;
	private Double price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movie_id", nullable = false)
	private Movie movie;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "theater_id", nullable = false)
	private Theater theater;

	@OneToMany(mappedBy = "show", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Booking> bookings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Show(Long id, LocalDateTime showTime, Double price, Movie movie, Theater theater, List<Booking> bookings) {
		super();
		this.id = id;
		this.showTime = showTime;
		this.price = price;
		this.movie = movie;
		this.theater = theater;
		this.bookings = bookings;
	}

	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Show [id=" + id + ", showTime=" + showTime + ", price=" + price + ", movie=" + movie + ", theater="
				+ theater + ", bookings=" + bookings + "]";
	}

}
