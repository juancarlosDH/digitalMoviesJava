package com.dh.jc.Primero.JC1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.dh.jc.Primero.JC1.model.Movie;

import com.dh.jc.Primero.JC1.services.MovieService;
import com.dh.jc.Primero.JC1.services.GenreService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController
{
	private MovieService movieService;
	private GenreService genreService;

	public MovieController(MovieService movieService, GenreService genreService)
	{
		this.movieService = movieService;
		this.genreService = genreService;
	}

	@GetMapping("")
	public String index(Model model) 
	{
		model.addAttribute("movies", this.movieService.findAll());
		return "movies/index";
	}

	@GetMapping("/new")
	public String newMovie(Movie movie, Model model)
	{
		model.addAttribute("genres", this.genreService.findAll());
		return "movies/new";
	}

	@PostMapping("")
	public String create(@Valid Movie movie, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors()) {
			model.addAttribute("genres", this.genreService.findAll());
			return "movies/new";
		}
		Movie newMovie = this.movieService.save(movie);
		return "redirect:/movies";
	}

	@GetMapping(value = "/{id}/edit")
	public String edit(@PathVariable(value = "id") Integer id, Model model)
	{
		model.addAttribute("genres", this.genreService.findAll());
		Optional<Movie> movie = this.movieService.findById(id);
		model.addAttribute("movie", movie.get());
		return "movies/form";
	}

	@PostMapping(value="/{id}/edit")
	public String update(@Valid Movie movieEdit, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors()) {
			model.addAttribute("genres", this.genreService.findAll());
			return "movies/form";
		}
		this.movieService.save(movieEdit);
		return "redirect:/movies";
	}

}
