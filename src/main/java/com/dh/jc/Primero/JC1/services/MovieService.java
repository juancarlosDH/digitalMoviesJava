package com.dh.jc.Primero.JC1.services;

import com.dh.jc.Primero.JC1.apis.MovieApi;
import com.dh.jc.Primero.JC1.model.Movie;
import org.springframework.stereotype.Service;
import com.dh.jc.Primero.JC1.repository.MovieJPARepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements MovieApi {

    private MovieJPARepository movieJPARepository;

    public MovieService(MovieJPARepository movieJPARepository)
    {
        this.movieJPARepository = movieJPARepository;
    }

    public Movie save(Movie movie)
    {
        return this.movieJPARepository.save(movie);
    }

    public Optional<Movie> findById(Integer id)
    {
        return this.movieJPARepository.findById(id);
    }

    public List<Movie> findAll()
    {
        return this.movieJPARepository.findAll();
    }

}
