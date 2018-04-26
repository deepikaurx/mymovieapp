package com.qa.business.repository;

public interface IMovieRepository {

	String getAllMovies();
	
	String getAMovie(Long id);

	String createMovies(String movieJSON);

	String deleteMovie(Long id);
	
	String updateMovie(Long id);


}