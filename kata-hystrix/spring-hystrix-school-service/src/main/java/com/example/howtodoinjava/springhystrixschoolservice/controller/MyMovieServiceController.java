package com.example.howtodoinjava.springhystrixschoolservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.howtodoinjava.springhystrixschoolservice.delegate.MyMovieServiceDelegate;

@RestController
public class MyMovieServiceController {
	
	@Autowired
	MyMovieServiceDelegate myMovieServiceDelegate;

	@GetMapping("/myfinder/acteurs")
	public String getActeurs() {
		System.out.println("Getting All Acteurs");
		String response = myMovieServiceDelegate.callMyMovieServiceAndGetAllActeurs();
		System.out.println("Response Received as " + response);
		return "NORMAL FLOW !!! - All Acteurs -  " + response;
	}

	@GetMapping("/myfinder/films")
	public String getFilms() {
		System.out.println("Getting All Films");
		String response = myMovieServiceDelegate.callMyMovieServiceAndGetAllFilms();
		System.out.println("Response Received as " + response);
		return "NORMAL FLOW !!! - All Films -  " + response;
	}

	@GetMapping("/myfinder/acteurByName/{name}")
	public String getActeursByName(@PathVariable String name) {
		System.out.println("Getting Acteurs by name");
		String response = myMovieServiceDelegate.callMyMovieServiceAndGetActeurByName(name);
		System.out.println("Response Received as " + response);
		return "NORMAL FLOW !!! - Acteurs by name -  " + response;
	}

	@GetMapping("/myfinder/filmByTitle/{name}")
	public String getFilmByTitle(@PathVariable String name) {
		System.out.println("Getting Films by title");
		String response = myMovieServiceDelegate.callMyMovieServiceAndGetFilmByTitle(name);
		System.out.println("Response Received as " + response);
		return "NORMAL FLOW !!! - Films by title -  " + response;
	}

	@GetMapping("/myfinder/acteursByFilm/{name}")
	public String getActeursByFilm(@PathVariable String name) {
		System.out.println("Getting Acteurs by film");
		String response = myMovieServiceDelegate.callMyMovieServiceAndGetActeurByFilm(name);
		System.out.println("Response Received as " + response);
		return "NORMAL FLOW !!! - Acteurs by film -  " + response;
	}

	@GetMapping("/myfinder/filmByDate/{dateSortie}")
	public String getA(@PathVariable String dateSortie) {
		System.out.println("Getting Films by date");
		String response = myMovieServiceDelegate.callMyMovieServiceAndGetActeurByFilm(dateSortie);
		System.out.println("Response Received as " + response);
		return "NORMAL FLOW !!! - Films by date -  " + response;
	}

	
}
