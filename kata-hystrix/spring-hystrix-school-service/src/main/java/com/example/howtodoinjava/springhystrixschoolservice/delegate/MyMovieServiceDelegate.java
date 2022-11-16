package com.example.howtodoinjava.springhystrixschoolservice.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MyMovieServiceDelegate {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
	public String callMyMovieServiceAndGetAllActeurs() {
		System.out.println("Getting all acteurs ");
		String response = restTemplate
				.exchange("http://localhost:8010/acteurs"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - All Acteurs - :::  Acteurs Details " + response + " -  " + new Date();
	}

	@HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
	public String callMyMovieServiceAndGetAllFilms() {
		System.out.println("Getting all films");
		String response = restTemplate
				.exchange("http://localhost:8010/films"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - All Films - :::  Films Details " + response + " -  " + new Date();
	}

	@HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
	public String callMyMovieServiceAndGetActeurByName(String name) {
		System.out.println("Getting acteur by name " + name);
		String response = restTemplate
				.exchange("http://localhost:8010/acteurByName/{name}"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}, name).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Acteur by name - :::  Acteur Details " + response + " -  " + new Date();
	}

	@HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
	public String callMyMovieServiceAndGetFilmByTitle(String name) {
		System.out.println("Getting film by title " + name);
		String response = restTemplate
				.exchange("http://localhost:8010/filmByName/{name}"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}, name).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Film by name - :::  Film Details " + response + " -  " + new Date();
	}

	@HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
	public String callMyMovieServiceAndGetActeurByFilm(String film) {
		System.out.println("Getting Acteurs by film " + film);
		String response = restTemplate
				.exchange("http://localhost:8010/acteursByFilm/{film}"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}, film).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Acteurs by film - :::  Acteurs Details " + response + " -  " + new Date();
	}

	@HystrixCommand(fallbackMethod = "callMyMovieServiceAndGetData_Fallback")
	public String callMyMovieServiceAndGetFilmsByDateSortie(String dateSortie) {
		System.out.println("Getting Films by dateSortie " + dateSortie);
		String response = restTemplate
				.exchange("http://localhost:8010/filmByDate/{dateSortie}"
						, HttpMethod.GET
						, null
						, new ParameterizedTypeReference<String>() {
						}, dateSortie).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Films by dateSortie - :::  Films Details " + response + " -  " + new Date();
	}

	@SuppressWarnings("unused")
	private String callMyMovieServiceAndGetData_Fallback() {
		System.out.println("My movie Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From MyMovie Service at this moment. Service will be back shortly - " + new Date();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
