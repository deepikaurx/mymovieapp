package com.qa.business.repository;

public interface IMovieRepository {

	String getAllMovies();
	
	String getMovie(Long id);

	String createMovie(String movie);

	String deleteMovie(Long id);

}