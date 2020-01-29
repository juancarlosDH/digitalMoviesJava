package com.dh.jc.Primero.JC1.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="movies")
public class Movie {
	private String title;
	@Id
	private Integer id;
	private Double rating;
	private Float awards;
	
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
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Float getAwards() {
		return awards;
	}
	public void setAwards(Float awards) {
		this.awards = awards;
	}
	

}
