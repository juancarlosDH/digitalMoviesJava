package com.dh.jc.Primero.JC1.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name="movies")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message= "Titulo inválido, entre 2 y 30 letras")
	@Size(min=2, max=30)
	@Column(nullable = false)
	private String title;

	@NotNull(message = "Rating debe ser un numero")
	@Column(nullable = false, scale = 1, precision = 3)
	private BigDecimal rating;

	@NotNull(message = "Premios debe ser un numero")
	@Min(value = 0, message = "Premios debe ser un numero")
	@Column(nullable = false)
	private Integer awards;

	@Min(value = 0, message = "Rating debe ser un numero")
	@Column
	private Integer length;

	@NotNull(message = "Debe ser una fecha")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column
	private Date releaseDate;

	@OneToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public BigDecimal getRating() {
		return rating;
	}
	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}
	
	public Integer getAwards() {
		return awards;
	}
	public void setAwards(Integer awards) {
		this.awards = awards;
	}

	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date release_date) {
		this.releaseDate = release_date;
	}

	public Genre getGenre() {
		return this.genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getGenreName(){
		if (this.getGenre() != null) {
			return this.getGenre().getName();
		}
		return "";
	}


}
