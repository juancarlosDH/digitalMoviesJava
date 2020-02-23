package com.dh.jc.Primero.JC1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dh.jc.Primero.JC1.model.Movie;

@Repository
public interface MovieJPARepository extends JpaRepository<Movie, Integer> {
	
}
