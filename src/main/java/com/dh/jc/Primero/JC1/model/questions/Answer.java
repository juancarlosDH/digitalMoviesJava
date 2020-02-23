package com.dh.jc.Primero.JC1.model.questions;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Pregunta no puede estar vacia")
    @Size(min =2 , message= "Preguna al menos 2 letras")
    @Column
    private String text;

    @Column
    private Boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false, updatable = false)
    private Question question;

    public Answer() {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer )) return false;
        return id != null && id.equals(((Answer) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
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


}
