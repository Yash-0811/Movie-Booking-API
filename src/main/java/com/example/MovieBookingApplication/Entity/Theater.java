package com.example.MovieBookingApplication.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Theater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String theaterName;
	private String theaterLocation;
	private Integer theaterCapacity;
	private String theaterScreenType;

	@OneToMany(mappedBy = "theater", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Show> shows;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterLocation() {
		return theaterLocation;
	}

	public void setTheaterLocation(String theaterLocation) {
		this.theaterLocation = theaterLocation;
	}

	public Integer getTheaterCapacity() {
		return theaterCapacity;
	}

	public void setTheaterCapacity(Integer theaterCapacity) {
		this.theaterCapacity = theaterCapacity;
	}

	public String getTheaterScreenType() {
		return theaterScreenType;
	}

	public void setTheaterScreenType(String theaterScreenType) {
		this.theaterScreenType = theaterScreenType;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	public Theater(Long id, String theaterName, String theaterLocation, Integer theaterCapacity,
			String theaterScreenType, List<Show> shows) {
		super();
		this.id = id;
		this.theaterName = theaterName;
		this.theaterLocation = theaterLocation;
		this.theaterCapacity = theaterCapacity;
		this.theaterScreenType = theaterScreenType;
		this.shows = shows;
	}

	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Theater [id=" + id + ", theaterName=" + theaterName + ", theaterLocation=" + theaterLocation
				+ ", theaterCapacity=" + theaterCapacity + ", theaterScreenType=" + theaterScreenType + ", shows="
				+ shows + "]";
	}

}
