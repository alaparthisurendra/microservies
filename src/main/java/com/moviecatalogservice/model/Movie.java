package com.moviecatalogservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Movie implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer movieId;
	

	private String name;
	
	public Movie() {
		super();
	}

	public Movie(Integer movieId, String name) {
		super();
		this.movieId = movieId;
		this.name = name;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
