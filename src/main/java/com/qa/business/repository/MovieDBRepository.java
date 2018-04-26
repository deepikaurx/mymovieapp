package com.qa.business.repository;


import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


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


	

	

}
