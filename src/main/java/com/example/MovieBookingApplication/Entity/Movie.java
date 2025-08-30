package com.example.MovieBookingApplication.Entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String genre;
	private Integer duration;
	private LocalDate releaseDate;
	private String language;
	
	@OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Show> show;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Show> getShow() {
		return show;
	}

	public void setShow(List<Show> show) {
		this.show = show;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(Long id, String name, String description, String genre, Integer duration, LocalDate releaseDate,
			String language, List<Show> show) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.genre = genre;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.language = language;
		this.show = show;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", description=" + description + ", genre=" + genre
				+ ", duration=" + duration + ", releaseDate=" + releaseDate + ", language=" + language + ", show="
				+ show + "]";
	}
	
	
	
}
