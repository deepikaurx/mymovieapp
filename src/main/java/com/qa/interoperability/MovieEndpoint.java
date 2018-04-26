package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.service.IMovieService;

@Path("/movie")
public class MovieEndpoint {

	@Inject
	private IMovieService service;
	

	@GET
	@Path("/json")
	@Produces(("application/json"))
	public String getAllMovies() {
		return service.getAllMovies();
	}
	
	
	@GET
	@Path("json/{id}")
	@Produces({"application/json"})
	public String getAMovie(@PathParam("id")Long id) {
		return service.getAMovie(id);
	}
	
	@POST
	@Path("json")
	@Produces(("application/json"))
	public String createMovie(String jsonString) {
		return service.createMovie(jsonString);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteMovie(@PathParam("id") Long id) {
		return service.deleteMovie(id);

	}
	
	
	@POST
	@Path("json/{id}")
	@Produces({"application/json"})
	public String updateMovie(@PathParam("id")Long id) {
		return service.updateMovie(id);
	}
	
	
	
}
