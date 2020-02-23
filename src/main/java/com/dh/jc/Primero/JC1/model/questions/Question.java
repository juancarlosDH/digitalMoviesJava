package com.dh.jc.Primero.JC1.model.questions;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity (name = "question")
@Table (name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Pregunta no puede estar vacia")
    @Size(min =2 , message= "Preguna al menos 2 letras")
    @Column
    private String text;

    @OneToMany(mappedBy = "question",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Answer> answers;

    public Question() {
        answers = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
        answer.setQuestion(this);
    }

    public List<Answer> getAnswers() {
        return this.answers;
    }

    public List<Answer> getCorrectAnswers() {
       return (List<Answer>) this.getAnswers()
               .stream()
               .filter(answer -> answer.getCorrect().equals(true))
               .collect(Collectors.toList());
    }
}
