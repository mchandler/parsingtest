package com.mike.codetest.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mike.codetest.response.SoccerResponse;
import com.mike.codetest.response.WeatherResponse;
import com.mike.codetest.service.ParsingService;

@Path("/test")
public class TestResource {
	
	private ParsingService parsingService;
	
	public TestResource() {
		parsingService = new ParsingService();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response check() {
		return Response.status(200).entity("It works!").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/weather")
	public WeatherResponse getWeather() {
		return parsingService.parseWeather();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/soccer")
	public SoccerResponse getSoccer() {
		return parsingService.parseSoccer();
	}
	
}
