package com.moviecatalogservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Rating implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer rId;
	
	
	private Integer movieId;
	
	
	private Integer rating;
	
	public Rating(Integer movieId, Integer rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}
	public Rating() {
		super();
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	

}
