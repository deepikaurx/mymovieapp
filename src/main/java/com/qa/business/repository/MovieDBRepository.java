package com.qa.business.repository;


import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.domain.Movie;
import com.qa.util.JSONUtil;


public class MovieDBRepository implements IMovieRepository {
	
	private static final Logger LOGGER = Logger.getLogger(MovieDBRepository.class);

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllMovies() {
		LOGGER.info("In MovieDBRepository getAllMovies");
		Query query = manager.createQuery("Select m FROM Movie m");
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		return util.getJSONForObject(movies);
	}

	@Override
	public String getAMovie(Long id) {
		 Movie amovie = findMovie(id);
		 if(amovie != null) {
			 return util.getJSONForObject(amovie);
			 
		 } else {
			 return  "{\"message\":\"movie not found\"}";
		 }
	
	}

	private Movie findMovie(Long id) {
	 return manager.find(Movie.class, id);
		
	}

	@Override
	@Transactional(REQUIRED)
	public String createMovies(String movieJSON) {
		Movie aMovie = util.getObjectForJSON(movieJSON, Movie.class);
				manager.persist(aMovie);;
				return "{\"message\":\"movie created\"}";

	}


	@Override
	@Transactional(REQUIRED)
	public String deleteMovie(Long id) {
		Movie aMovie = findMovie(id);
		if (aMovie != null) {
			manager.remove(aMovie);
			return "{\"message\": \"movie deleted!!\"}";
		}
		else {
			return "{\"message\": \"movie not found\"}";
		}
		
	}
	

	
	

}
