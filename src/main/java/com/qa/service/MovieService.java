package com.qa.service;

import javax.inject.Inject;

import com.qa.business.repository.IMovieRepository;

public class MovieService implements IMovieService {
	@Inject
	private IMovieRepository repo;
	
	
	@Override
	public String getAllMovies() {
		return repo.getAllMovies();
	}


	@Override
	public String getAMovie(Long id) {
		
		return repo.getAMovie(id);
		
	}


	@Override
	public String createMovie(String jsonMovie) {
	
		return repo.createMovies(jsonMovie);
	}
	
	@Override
	public String deleteMovie(Long id) {
		
		return repo.deleteMovie(id);
	}
	
	
	
	@Override
	public String updateMovie(String JSONMovie) {
		
		return repo.updateMovie(JSONMovie);
		
	}

	
	
	
}


