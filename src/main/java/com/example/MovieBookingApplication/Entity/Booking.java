package com.example.MovieBookingApplication.Entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numberOfSeats;
	private LocalDateTime bookingTime;
	private Double price;
	private BookingStatus bookingStatus;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "booking_seat_numbers")
	private List<String> seatNumbers;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "show_id", nullable = false)
	private Show show;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public List<String> getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(List<String> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public Booking(Long id, Integer numberOfSeats, LocalDateTime bookingTime, Double price, BookingStatus bookingStatus,
			List<String> seatNumbers, User user, Show show) {
		super();
		this.id = id;
		this.numberOfSeats = numberOfSeats;
		this.bookingTime = bookingTime;
		this.price = price;
		this.bookingStatus = bookingStatus;
		this.seatNumbers = seatNumbers;
		this.user = user;
		this.show = show;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", numberOfSeats=" + numberOfSeats + ", bookingTime=" + bookingTime + ", price="
				+ price + ", bookingStatus=" + bookingStatus + ", seatNumbers=" + seatNumbers + ", user=" + user
				+ ", show=" + show + "]";
	}

}
