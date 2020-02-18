package com.dh.jc.Primero.JC1.controller;

import com.dh.jc.Primero.JC1.validators.MovieForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.dh.jc.Primero.JC1.model.Movie;

import repository.GenreJPARepository;
import repository.MovieJPARepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController
{
	private MovieJPARepository movieJpaRepository;
	private GenreJPARepository genreJPARepository;

	public MovieController(MovieJPARepository movieJpaRepository, GenreJPARepository genreJPARepository)
	{
		this.movieJpaRepository = movieJpaRepository;
		this.genreJPARepository = genreJPARepository;
	}

	@GetMapping("")
	public String index(Model model) 
	{
		model.addAttribute("movies", this.movieJpaRepository.findAll());
		return "movies/index";
	}

	@GetMapping("/new")
	public String newMovie(Movie movie, Model model)
	{
		model.addAttribute("genres", this.genreJPARepository.findAll());
		return "movies/new";
	}

	@PostMapping("")
	public String create(@Valid Movie movie, BindingResult bindingResult, Model model)
	{
		model.addAttribute("data", bindingResult.getAllErrors());
		if (bindingResult.hasErrors()) {
			return "movies/new";
		}
		Movie newMovie = this.movieJpaRepository.save(movie);
		return "redirect:/movies";
	}

	@GetMapping(value = "/{id}/edit")
	public String edit(@PathVariable(value = "id") Integer id, Model model)
	{
		model.addAttribute("genres", this.genreJPARepository.findAll());
		Optional<Movie> movie = movieJpaRepository.findById(id);
		model.addAttribute("movie", movie.get());
		return "movies/form";
	}

	@PostMapping(value="/{id}/edit")
	public String update(@PathVariable(value = "id") Integer id, @Valid Movie movieEdit, BindingResult bindingResult, Model model)
	{
		model.addAttribute("data", bindingResult.getAllErrors());
		if (bindingResult.hasErrors()) {
			Optional<Movie> movie = movieJpaRepository.findById(id);
			model.addAttribute("genres", this.genreJPARepository.findAll());
			return "movies/form";
		}
		Movie newMovie = this.movieJpaRepository.save(movieEdit);
		return "redirect:/movies";
	}

}
