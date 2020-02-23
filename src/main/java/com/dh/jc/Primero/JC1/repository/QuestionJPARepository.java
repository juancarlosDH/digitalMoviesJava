package com.dh.jc.Primero.JC1.repository;

import com.dh.jc.Primero.JC1.model.questions.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionJPARepository extends JpaRepository<Question, Integer> {

}
