package com.dh.jc.Primero.JC1.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

import com.dh.jc.Primero.JC1.model.Movie;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MovieForm  {

    @NotNull(message= "Titulo inválido, entre 2 y 30 letras")
    @Size(min=2, max=30)
    private String title;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String toString()
    {
        return "Movie Objecttttt";
    }
}
