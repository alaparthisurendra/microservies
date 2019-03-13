package com.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.moviecatalogservice.model.CatalogItem;
import com.moviecatalogservice.model.Movie;
import com.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@Autowired
	private RestTemplate restTemplate;

	//@Autowired
	//private WebClient.Builder webClientBuilder;

	/*// @GetMapping("/{userId}")
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable(value = "userId") String userId) {*/

		// WebClient.Builder builder=WebClient.builder();
		// assume that this data cmg from rating api
		//List<Rating> ratings = Arrays.asList(new Rating("111", 3), new Rating("112", 4), new Rating("113", 2));

		// step:1 get all rated movie ids
		// step:2 for each movie id call movie info and get details
		// step:3 put them all together

		// this name and description come from Api here we hardcoding

		/*UserRating ratings1 = restTemplate.getForObject("http://RATING-SERVICE/rating/users/" + userId,
				UserRating.class);

		return ratings1.getUserRating().stream().map(rating -> {
			final String uri = "http://MOVIE-INFO-SERVICE/movie/movieId";
			// Movie movie = restTemplate.getForObject("http://localhost:9092/movie/" +
			// rating.getMovieId(), Movie.class);
			Movie movie = restTemplate.getForObject(uri, Movie.class);
			return new CatalogItem( movie.getMovieId(), movie.getName(), "village development", rating.getRating());
		}).collect(Collectors.toList());
*/
		/*
		 * return ratings.stream() .map(rating -> { Movie movie =
		 * restTemplate.getForObject("http://localhost:9092/movie/" +
		 * rating.getMovieId(), Movie.class); return new CatalogItem(movie.getName(),
		 * "village development", rating.getRating()); }) .collect(Collectors.toList());
		 */

		/*
		 * return ratings.stream() .map(rating ->{ Movie movie=webClientBuilder.build()
		 * .get() .uri("http://localhost:9092/movie/" + rating.getMovieId()) .retrieve()
		 * .bodyToMono(Movie.class) .block(); return new CatalogItem(movie.getName(),
		 * "village development", rating.getRating()); }) .collect(Collectors.toList());
		 */

		/*
		 * @RequestMapping("/{userId}") public List<CatalogItem>
		 * getCatalog1(@PathVariable(value="userId") String userId){ List<Rating>
		 * ratings1=restTemplate.getForObject("http://localhost:9090/rating/users/"
		 * +userId, UserRating.class).getUserRating(); return
		 * ratings1.stream().map(rating ->{ final String uri
		 * ="http://localhost:9092/movie/movieId"; Movie forObject =
		 * restTemplate.getForObject(uri, Movie.class); return new
		 * CatalogItem(forObject.getName(), "village development", rating.getRating());
		 * }).collect(Collectors.toList());
		 */

	//@GetMapping("/{rId}")
	 @RequestMapping("/{cid}")
	public List<CatalogItem> getCatalogItems(@PathVariable("cid") String cid) {
		
		final String uri = "http://localhost:9090/rating/all";
	  UserRating ratings = restTemplate.getForObject(uri, UserRating.class);
		
	  return ratings.getUserRating().stream().map(rating -> {
			final String url = "http://MOVIE-INFO-SERVICE/movie/movieId";
			// Movie movie = restTemplate.getForObject("http://localhost:9092/movie/" +
			// rating.getMovieId(), Movie.class);
			Movie movie = restTemplate.getForObject(url, Movie.class);
			return new CatalogItem( 1, movie.getName(), "village development", rating.getRating());
		}).collect(Collectors.toList());
	}
}
