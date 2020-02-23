package com.dh.jc.Primero.JC1.controller.rest;

import com.dh.jc.Primero.JC1.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.jc.Primero.JC1.repository.MovieJPARepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieRestController
{

    private MovieJPARepository movieJPARepository;

    public MovieRestController(MovieJPARepository movieJPARepository)
    {
        this.movieJPARepository = movieJPARepository;
    }

    @GetMapping("")
    public List<Movie> list ()
    {
        return this.movieJPARepository.findAll();
    }

}
