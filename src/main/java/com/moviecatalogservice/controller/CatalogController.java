package com.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.moviecatalogservice.model.CatalogItem;
import com.moviecatalogservice.model.Movie;
import com.moviecatalogservice.model.Rating;
import com.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	//@GetMapping("/{userId}")
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable(value="userId") String userId){
		
		//WebClient.Builder builder=WebClient.builder();
		//assume that this data cmg from rating api
		List<Rating> ratings=Arrays.asList(
				new Rating("111",4),
				new Rating("112",3)
				);
		
		// step:1 get all rated movie ids
		// step:2 for each movie id call movie info and get details
		//  step:3 put them all together
		
		//this name and description come from Api here we hardcoding
		
		UserRating ratings1=restTemplate.getForObject("http://localhost:9090/rating/users/" +userId, UserRating.class);
		
		return  ratings1.getUserRating().stream().map(rating ->{
		 Movie movie = restTemplate.getForObject("http://localhost:9092/movie/" + rating.getMovieId(), Movie.class);
		 return new CatalogItem(movie.getName(), "village development", rating.getRating());
	})
				.collect(Collectors.toList());
		
		/* return ratings.stream()
	                .map(rating -> {
	                    Movie movie = restTemplate.getForObject("http://localhost:9092/movie/" + rating.getMovieId(), Movie.class);
	                    return new CatalogItem(movie.getName(), "village development", rating.getRating());
	                })
	                .collect(Collectors.toList());*/
		
		/*return ratings.stream()
				.map(rating ->{
					 Movie movie=webClientBuilder.build()
					.get()
					.uri("http://localhost:9092/movie/" + rating.getMovieId())
					.retrieve()
					.bodyToMono(Movie.class)
					.block();
					return new CatalogItem(movie.getName(), "village development", rating.getRating());
				})
				.collect(Collectors.toList());*/
			
		
		
	}
}
