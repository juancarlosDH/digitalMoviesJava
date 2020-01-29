package com.dh.jc.Primero.JC1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import services.interfaces.MovieJPARepository;
import com.dh.jc.Primero.JC1.models.Movie;

@RestController
public class MovieController {
	
	@Autowired
	private MovieJPARepository movieJpaRepository;
		
	@GetMapping("/movies")
	public List<Movie> index() 
	{
		return movieJpaRepository.findAll();
		//return "index";
	}

}
