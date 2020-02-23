package com.dh.jc.Primero.JC1.services;

import com.dh.jc.Primero.JC1.apis.GenreApi;
import com.dh.jc.Primero.JC1.model.Genre;
import com.dh.jc.Primero.JC1.repository.GenreJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements GenreApi {

    private GenreJPARepository genreJPARepository;

    public GenreService(GenreJPARepository genreJPARepository)
    {
        this.genreJPARepository = genreJPARepository;
    }

    public List<Genre> findAll()
    {
        return  this.genreJPARepository.findAll();
    }

}
