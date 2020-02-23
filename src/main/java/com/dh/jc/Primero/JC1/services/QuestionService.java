package com.dh.jc.Primero.JC1.services;

import com.dh.jc.Primero.JC1.model.questions.Answer;
import com.dh.jc.Primero.JC1.model.questions.Question;
import com.dh.jc.Primero.JC1.repository.QuestionJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionJPARepository questionJPARepository;

    public QuestionService(QuestionJPARepository questionJPARepository)
    {
        this.questionJPARepository = questionJPARepository;
    }

    public List<Question> findAll()
    {
        return this.questionJPARepository.findAll();
    }

    public Question findById(Integer id) throws Exception
    {
        Optional<Question> question = this.questionJPARepository.findById(id);

        if (question.isPresent()) {
            return question.get();
        }

        throw new Exception("Question not found");
    }

    public Boolean isCorrectAnswer(Question question, Answer answer)
    {
        return  question.getCorrectAnswers()
                .stream()
                .filter(ans -> ans.equals(answer))
                .findAny().isPresent();
    }

}
