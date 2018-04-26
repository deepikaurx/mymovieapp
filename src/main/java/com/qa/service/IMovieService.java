package com.qa.service;

public interface IMovieService {
	String getAllMovies();

	String getAMovie(Long id);
	
	String createMovie(String jsonMovie);
	
	String deleteMovie(Long id);

	
}
