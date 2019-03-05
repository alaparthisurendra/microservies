package com.moviecatalogservice.model;

public class Rating {
	
	private String movieId;
	private Integer rating;
	
	public Rating(String movieId, Integer rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}
	public Rating() {
		super();
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	

}
